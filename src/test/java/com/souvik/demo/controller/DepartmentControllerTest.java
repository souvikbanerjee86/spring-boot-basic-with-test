package com.souvik.demo.controller;

import com.souvik.demo.entity.Department;
import com.souvik.demo.error.DepartmentNotFoundException;
import com.souvik.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("IT")
                .departmentId(1L)
                .departmentAddress("KOLKATA")
                .departmentCode("CC-01").build();


    }

    @Test
    void insertDepartment() throws Exception {
      Department  inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("KOLKATA")
                .departmentCode("CC-01").build();
        Mockito.when(departmentService.insertDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/api/v1/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"IT\",\n" +
                        "    \"departmentAddress\":\"KOLKATA\",\n" +
                        "    \"departmentCode\":\"CC-01\"\n" +
                        "}")
        ).andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/api/v1/departments/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}