package com.snehansh.SpringRestAPI.controller;

import com.snehansh.SpringRestAPI.entity.Department;
import com.snehansh.SpringRestAPI.error.DepartmentNotFoundException;
import com.snehansh.SpringRestAPI.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    /*
    Create New department entry
     */
    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department){
        return  departmentService.createDepartment(department);
    }
    /*
    Get all the department details in a list
     */
    @GetMapping("/department")
    public List<Department> getDepartment() {
        return departmentService.getDepartment();

    }
    /*
    Get department by departmentId
     */
    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException{
        return departmentService.getDepartment(departmentId);
    }
    /*
    Get department by department Name
     */
    @GetMapping("/department/name/{name}")
    public Department getDepartment(@PathVariable("name") String departmentName) throws  DepartmentNotFoundException{
        return  departmentService.getDepartment(departmentName);
    }
    /*
    Update department by departmentId
    * */
    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
    /*
    Delete department by Department Id
     */

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException{
        return departmentService.deleteDepartment(departmentId);
    }
}
