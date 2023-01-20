package com.snehansh.SpringRestAPI.repository;

import com.snehansh.SpringRestAPI.entity.Department;
import com.snehansh.SpringRestAPI.error.DepartmentNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentNameIgnoreCase(String departmentName) throws DepartmentNotFoundException;
}
