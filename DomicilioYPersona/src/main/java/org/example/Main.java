package org.example;

import org.example.entities.Domicilio;
import org.example.entities.Persona;
import org.example.services.PersonaService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonaService service = new PersonaService();

        Domicilio dom = new Domicilio();
        dom.setCalle("Av. Siempre Viva");
        dom.setCiudad("Springfield");

        Persona p = new Persona();
        p.setNombre("Homero");
        p.setApellido("Simpson");
        p.setDomicilio(dom);

        try {
            service.guardarPersona(p);

            List<Persona> personas = service.obtenerTodas();
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
