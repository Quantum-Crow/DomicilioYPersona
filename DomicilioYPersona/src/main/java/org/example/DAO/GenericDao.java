package org.example.DAO;


import org.example.entities.Persona;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    void insertar(Persona persona) throws Exception;

    void guardar(T t) throws SQLException;
    void actualizar(T t) throws SQLException;
    void eliminar(long id) throws SQLException;
    T buscarPorId(long id) throws SQLException;
    List<T> buscarTodos() throws SQLException;

    List<Persona> listarTodos() throws Exception;
}
