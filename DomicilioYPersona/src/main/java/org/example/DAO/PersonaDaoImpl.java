package org.example.DAO;


import org.example.config.DatabaseConnectionPool;
import org.example.entities.Domicilio;
import org.example.entities.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao {

    @Override
    public void insertar(Persona persona) throws Exception {
        String insertDomicilio = "INSERT INTO domicilio (calle, ciudad) VALUES (?, ?)";
        String insertPersona = "INSERT INTO persona (nombre, apellido, domicilio_id) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnectionPool.getConnection()) {
            conn.setAutoCommit(false);

            // Insertar domicilio primero
            try (PreparedStatement stmtDomicilio = conn.prepareStatement(insertDomicilio, Statement.RETURN_GENERATED_KEYS)) {
                stmtDomicilio.setString(1, persona.getDomicilio().getCalle());
                stmtDomicilio.setString(2, persona.getDomicilio().getCiudad());
                stmtDomicilio.executeUpdate();

                ResultSet keys = stmtDomicilio.getGeneratedKeys();
                if (keys.next()) {
                    persona.getDomicilio().setId(keys.getInt(1));
                }
            }

            // Insertar persona con el ID del domicilio
            try (PreparedStatement stmtPersona = conn.prepareStatement(insertPersona)) {
                stmtPersona.setString(1, persona.getNombre());
                stmtPersona.setString(2, persona.getApellido());
                stmtPersona.setInt(3, persona.getDomicilio().getId());
                stmtPersona.executeUpdate();
            }

            conn.commit();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }
    }

    @Override
    public void guardar(Persona persona) throws SQLException {

    }

    @Override
    public void actualizar(Persona persona) throws SQLException {

    }

    @Override
    public void eliminar(long id) throws SQLException {

    }

    @Override
    public Persona buscarPorId(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Persona> buscarTodos() throws SQLException {
        return List.of();
    }

    @Override
    public List<Persona> listarTodos() throws Exception {
        List<Persona> personas = new ArrayList<>();

        String query = """
            SELECT p.id, p.nombre, p.apellido,
                   d.id as domicilio_id, d.calle, d.ciudad
            FROM persona p
            JOIN domicilio d ON p.domicilio_id = d.id
        """;

        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Domicilio domicilio = new Domicilio();
                domicilio.setId(rs.getInt("domicilio_id"));
                domicilio.setCalle(rs.getString("calle"));
                domicilio.setCiudad(rs.getString("ciudad"));

                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setDomicilio(domicilio);

                personas.add(persona);
            }

        } catch (SQLException e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }

        return personas;
    }
}
