package org.example.services;

public interface GenericService<T> {
    void guardar (T entity) throws Exception;
}
