package com.souvik.demo.controller;

import com.souvik.demo.entity.Department;
import com.souvik.demo.error.DepartmentNotFoundException;
import com.souvik.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/departments")
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public Department insertDepartment(@Valid @RequestBody Department department){
            LOGGER.info("Inside insertDepartment of DepartmentController");
            return departmentService.insertDepartment(department);
    }

    @GetMapping
    public List<Department> getDepartments(){
        LOGGER.info("Inside getDepartments of DepartmentController");
        return departmentService.getDepartments();
    }
    @GetMapping(path = "/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping(path = "/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId , @RequestBody Department department){
       return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping(path = "/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
            return departmentService.fetchDepartmentByName(departmentName);
    }
}
