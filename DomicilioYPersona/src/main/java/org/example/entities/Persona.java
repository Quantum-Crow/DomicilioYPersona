package org.example.entities;

import lombok.Data;

@Data
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
}
