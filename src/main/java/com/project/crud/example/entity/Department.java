package com.project.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

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
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int did;
    @NotBlank
    private String name;
    @OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
    private List<Employee> employees;
}
