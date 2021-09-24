package com.startech.service;

import com.startech.model.Department;
import com.startech.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{


    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department depFindById(int id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        }
        return null;
    }

}
