package com.startech.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departmenTbl")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "department_code")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_code;
    private String department_name;
    @ManyToMany
    @JoinTable(name = "join_employee_departmentTbl",
            joinColumns = {@JoinColumn(name = "department_code", referencedColumnName = "department_code")},
            inverseJoinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")}
    )
    private List<Employee> employees;
}
