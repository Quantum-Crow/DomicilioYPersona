package org.example.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Domicilio {
    private int id;
    private String calle;
    private String ciudad;
}
