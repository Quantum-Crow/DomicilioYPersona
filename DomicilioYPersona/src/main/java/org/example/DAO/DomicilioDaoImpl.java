package org.example.DAO;

import org.example.DAO.GenericDao;
import org.example.entities.Domicilio;
import org.example.config.DatabaseConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoImpl implements GenericDao<Domicilio> {

    @Override
    public void insertar(Domicilio domicilio) throws Exception {
        String sql = "INSERT INTO domicilio (calle, ciudad) VALUES (?, ?)";

        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, domicilio.getCalle());
            stmt.setString(2, domicilio.getCiudad());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                domicilio.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            throw new Exception("Error insertando domicilio: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Domicilio> listarTodos() throws Exception {
        List<Domicilio> domicilios = new ArrayList<>();

        String sql = "SELECT id, calle, ciudad FROM domicilio";

        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Domicilio d = new Domicilio();
                d.setId(rs.getInt("id"));
                d.setCalle(rs.getString("calle"));
                d.setCiudad(rs.getString("ciudad"));
                domicilios.add(d);
            }

        } catch (SQLException e) {
            throw new Exception("Error listando domicilios: " + e.getMessage(), e);
        }

        return domicilios;
    }
}
