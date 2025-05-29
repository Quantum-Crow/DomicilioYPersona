package org.example;

import org.example.entities.Domicilio;
import org.example.entities.Persona;
import org.example.services.DomicilioServicio;
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

        // Solo como demostración adicional
        DomicilioServicio domicilioService = new DomicilioServicio();

        Domicilio nuevoDom = new Domicilio();
        nuevoDom.setCalle("Calle Falsa 123");
        nuevoDom.setCiudad("Shelbyville");

        try {
            domicilioService.guardarDomicilio(nuevoDom);
            System.out.println("Domicilio guardado: " + nuevoDom);

            List<Domicilio> lista = domicilioService.obtenerTodos();
            lista.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
