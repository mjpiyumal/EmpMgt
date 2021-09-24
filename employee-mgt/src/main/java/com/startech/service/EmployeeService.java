package com.startech.service;

import com.startech.model.Department;
import com.startech.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee empFindById(int id);

    String deleteById(int id);

}
