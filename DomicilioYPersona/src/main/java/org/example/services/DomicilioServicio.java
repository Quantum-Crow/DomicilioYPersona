package org.example.services;

import org.example.DAO.DomicilioDao;
import org.example.entities.Domicilio;

import java.sql.SQLException;
import java.util.List;

public class DomicilioServicio implements GenericService<Domicilio> {

    private final DomicilioDao domicilioDao;

    public DomicilioServicio(DomicilioDao domicilioDao) {
        this.domicilioDao = domicilioDao;
    }

    @Override
    public void guardar(Domicilio domicilio) throws SQLException {
        validar(domicilio);
        domicilioDao.guardar(domicilio);
    }

    private void validar(Domicilio domicilio) {
    }

    @Override
    public void actualizar(Domicilio domicilio) throws SQLException {
        validar(domicilio);
        domicilioDao.actualizar(domicilio);
    }

    @Override
    public void eliminar(long id) throws SQLException {
        domicilioDao.eliminar(id);
    }

    @Override
    public Domicilio buscarPorId(long id) throws SQLException {
        return domicilioDao.buscarPorId(id);
    }

    @Override
    public List<Domicilio> buscarTodos() throws SQLException {
        return domicilioDao.buscarTodos();
    }

}
