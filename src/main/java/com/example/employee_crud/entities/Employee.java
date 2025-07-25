package com.example.employee_crud.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_generator")
    @SequenceGenerator(name ="id_sequence_generator", sequenceName = "id_sequence_generator")
    private int id;
    private String name;
    private String role;

}
