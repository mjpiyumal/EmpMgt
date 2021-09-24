package com.startech.service;

import com.startech.model.Department;
import com.startech.model.Employee;
import com.startech.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    DepartmentService departmentService;

    @Override
    public Employee save(Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setFirst_name(employee.getFirst_name());
        newEmployee.setLast_name(employee.getLast_name());
        newEmployee.setContact_no(employee.getContact_no());
        newEmployee.setAddress(employee.getAddress());

        newEmployee.getDepartments()
                .addAll(employee
                        .getDepartments()
                        .stream()
                        .map(dep -> {
                            Department department = departmentService.depFindById(dep.getDepartment_code());
                            department.getEmployees().add(newEmployee);
                            return department;
                        }).collect(Collectors.toList()));
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee empFindById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }


    @Override
    public String deleteById(int id) {
        employeeRepository.deleteById(id);
        return  "ID " +id+ " Deleted successfully";
    }
}
