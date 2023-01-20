package com.snehansh.SpringRestAPI.service;

import com.snehansh.SpringRestAPI.entity.Department;
import com.snehansh.SpringRestAPI.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department createDepartment(Department department);

    public List<Department> getDepartment();

    public Department getDepartment(Long departmentId) throws DepartmentNotFoundException;

    public Department updateDepartment(Long departmentId, Department department);

    public String deleteDepartment(Long departmentId) throws DepartmentNotFoundException;

    public Department getDepartment(String departmentName) throws DepartmentNotFoundException;
}
