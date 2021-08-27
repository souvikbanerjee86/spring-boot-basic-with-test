package com.souvik.demo.repository;

import com.souvik.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical")
                .departmentAddress("KOLKATA")
                .departmentCode("M-KOL-002")
                .build();
        entityManager.persist(department);
    }

    @Test
    @DisplayName("Get Department based on the Department ID")
    public void whenFindByIdThenReturnDepartment(){
        Optional<Department> department = departmentRepository.findById(1L);
        assertEquals(department.get().getDepartmentName(),"Mechanical");
    }
}