package com.project.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;
    @NotBlank
    private String name;
    @NotNull
    private int age;
    @NotBlank
    private String department;

}
