package org.example.DAO;

import org.example.entities.Domicilio;
import org.example.entities.Persona;

import java.util.List;

public interface DomicilioDao extends GenericDao<Domicilio> {
    void insertar(Domicilio domicilio) throws Exception;

    List<Persona> listarTodos() throws Exception;
}