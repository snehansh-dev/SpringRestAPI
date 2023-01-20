package com.snehansh.SpringRestAPI.service;

import com.snehansh.SpringRestAPI.entity.Department;
import com.snehansh.SpringRestAPI.error.DepartmentNotFoundException;
import com.snehansh.SpringRestAPI.repository.DepartmentRepository;
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
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department does not exist");
        }
        return department.get();
    }
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDb = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentName(department.getDepartmentName());
        }
        return departmentRepository.save(depDb);
    }

    @Override
    public String deleteDepartment(Long departmentId) throws DepartmentNotFoundException{
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        String message;
        if(!optionalDepartment.isPresent()){
            throw new DepartmentNotFoundException("Department does not exist");
        }else{
            departmentRepository.deleteById(departmentId);
            message = "department".concat(optionalDepartment.get().getDepartmentName()).concat(" does not exist");
        }
        return message;
    }

    @Override
    public Department getDepartment(String departmentName) throws DepartmentNotFoundException {

        Department department =  departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if(Objects.isNull(department)){
            throw new DepartmentNotFoundException("Department does not exist");
        }
        return department;
    }
}
