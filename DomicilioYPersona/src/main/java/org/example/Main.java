package org.example;

import org.example.DAO.DomicilioDaoImpl;
import org.example.DAO.PersonaDaoImpl;
import org.example.entities.Domicilio;
import org.example.entities.Persona;
import org.example.services.DomicilioServicio;
import org.example.services.PersonaService;

public class Main {
    public static void main(String[] args) {
        try {
            DomicilioDaoImpl domicilioDAO = new DomicilioDaoImpl();
            PersonaDaoImpl personaDao = new PersonaDaoImpl();

            DomicilioServicio domicilioService = new DomicilioServicio(domicilioDAO);
            PersonaService PersonaService = new PersonaService(personaDao);

            Domicilio domicilio = Domicilio.builder()
                    .calle("Avenida Siempre Viva")
                    .ciudad("Springfield")
                    .build();

            domicilioService.guardar(domicilio);
            System.out.println("Domicilio ID: " + domicilio.getId());

            Persona persona = Persona.builder()
                    .nombre("Homero")
                    .apellido("Simpson")
                    .domicilio(domicilio)
                    .build();

            PersonaService.guardar(persona);
            System.out.println("Persona guardada con ID: " + persona.getId());


            Persona personaEncontrada = PersonaService.buscarPorId(persona.getId());
            if (personaEncontrada != null) {
                System.out.println("Esta es la persona: " + personaEncontrada.getNombre() + " " + personaEncontrada.getApellido());
            } else {
                System.out.println("No hay info");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       /*
       Creo que nada de esto funciona (Idea de antes de implementar lombok), lo dejamos por si alguien quiere intentar algo con esto
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
         //Solo como demostración adicional
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
        }*/

    }
