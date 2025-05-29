package org.example.services;

import org.example.DAO.PersonaDaoImpl;
import org.example.entities.Persona;

import java.sql.SQLException;
import java.util.List;

public class PersonaService implements GenericService<Persona>{
    private final PersonaDaoImpl personaDao;

    public PersonaService(PersonaDaoImpl personaDao) {
        this.personaDao = personaDao;
    }

    public void guardarPersona(Persona persona) throws Exception {
        personaDao.insertar(persona);
    }

    public List<Persona> obtenerTodas() throws Exception {
        return personaDao.listarTodos();
    }

    @Override
    public void guardar(Persona entity) {

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
}
