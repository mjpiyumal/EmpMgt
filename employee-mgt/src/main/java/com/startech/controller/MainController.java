package com.startech.controller;

import com.startech.model.Department;
import com.startech.model.Employee;
import com.startech.service.DepartmentService;
import com.startech.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class MainController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    DepartmentService departmentService;


    //Insert new employees
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }


    //Employee Find by ID
    @RequestMapping(value = "/fetchEmpById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> empFindById(@PathVariable int id) {
        Employee employee = employeeService.empFindById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(employee);
        }
    }


    //Delete Employee by ID
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable int id) {
         employeeService.deleteById(id);
        return "ID " +id+ " Deleted successfully";
    }


    //Department Find by ID
    @RequestMapping(value = "/fetchById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Department> fetchById(@PathVariable int id) {
        Department department = departmentService.depFindById(id);
        if (department == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(department);
        }
    }

}
