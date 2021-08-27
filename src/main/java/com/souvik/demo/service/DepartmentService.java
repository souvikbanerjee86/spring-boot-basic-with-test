package com.souvik.demo.service;

import com.souvik.demo.entity.Department;
import com.souvik.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department insertDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
