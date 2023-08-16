package com.swamhtetaung.Springboot.tutorial.service;

import com.swamhtetaung.Springboot.tutorial.entity.Department;
import com.swamhtetaung.Springboot.tutorial.errors.DepartmentNotFoundException;
import com.swamhtetaung.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department storeDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department is not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department updateDept = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentAddress()) && "" != department.getDepartmentAddress()){
            updateDept.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && "" != department.getDepartmentCode()){
            updateDept.setDepartmentCode(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentName()) && "" != department.getDepartmentName()){
            updateDept.setDepartmentName(department.getDepartmentName());
        }

        return departmentRepository.save(updateDept);

    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
