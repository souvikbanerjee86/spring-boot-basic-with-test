package com.souvik.demo.service;

import com.souvik.demo.entity.Department;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        Department department= Department.builder()
                .departmentName("IT")
                .departmentCode("IT-01")
                .departmentAddress("KOLKATA")
                .build();

        Mockito.when(departmentService.fetchDepartmentByName("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Department based on valid Department Name")
    public void whenValidDepartmentNameThenDepartmentShouldFound(){
        String departmentName="IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}