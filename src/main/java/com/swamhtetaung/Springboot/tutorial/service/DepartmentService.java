package com.swamhtetaung.Springboot.tutorial.service;

import com.swamhtetaung.Springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department storeDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);
}
