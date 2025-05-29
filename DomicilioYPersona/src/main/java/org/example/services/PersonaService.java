package org.example.services;

import org.example.DAO.PersonaDaoImpl;
import org.example.entities.Persona;

import java.util.List;

public class PersonaService implements GenericService<Persona>{
    private final PersonaDaoImpl personaDAO = new PersonaDaoImpl();

    public void guardarPersona(Persona persona) throws Exception {
        personaDAO.insertar(persona);
    }

    public List<Persona> obtenerTodas() throws Exception {
        return personaDAO.listarTodos();
    }

    @Override
    public void guardar(Persona entity) throws Exception {

    }
}
