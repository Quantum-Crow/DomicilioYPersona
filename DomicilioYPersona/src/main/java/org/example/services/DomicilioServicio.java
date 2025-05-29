package org.example.services;

import org.example.entities.Domicilio;
import org.example.DAO.DomicilioDaoImpl;

import java.util.List;

public class DomicilioServicio {
    private final DomicilioDaoImpl domicilioDAO = new DomicilioDaoImpl();

    public void guardarDomicilio(Domicilio domicilio) throws Exception {
        domicilioDAO.insertar(domicilio);
    }

    public List<Domicilio> obtenerTodos() throws Exception {
        return domicilioDAO.listarTodos();
    }
}
