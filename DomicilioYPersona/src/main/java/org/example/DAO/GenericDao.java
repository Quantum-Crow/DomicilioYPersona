package org.example.DAO;


import java.util.List;

public interface GenericDao<T> {
    void insertar(T entidad) throws Exception;
    List<T> listarTodos() throws Exception;
}
