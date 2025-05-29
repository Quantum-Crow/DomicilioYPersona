package org.example.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
}
