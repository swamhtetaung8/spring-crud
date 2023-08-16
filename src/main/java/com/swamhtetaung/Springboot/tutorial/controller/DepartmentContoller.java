package com.swamhtetaung.Springboot.tutorial.controller;

import com.swamhtetaung.Springboot.tutorial.entity.Department;
import com.swamhtetaung.Springboot.tutorial.errors.DepartmentNotFoundException;
import com.swamhtetaung.Springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentContoller {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentContoller.class);


    @PostMapping("/department")
    public Department storeDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside storeDepartment");
        return departmentService.storeDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getDepartments(){
        LOGGER.info("Inside getDepartments");
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
