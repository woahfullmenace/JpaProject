package com.project.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int did;
    @NotBlank
    private String name;
    @OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
    @JoinColumn(name="did" , referencedColumnName = "did")
    private List<Employee> employees;
}
