package com.github.jakubborkowski.jpa.service;

import com.github.jakubborkowski.jpa.model.Department;
import com.github.jakubborkowski.jpa.model.User;
import com.github.jakubborkowski.jpa.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void addNewDepartment() {
        //Given//
        List<User> Users = Collections.emptyList();
        //When//
        Department department = departmentService.addNewDepartment(
                "test", "test", "test",
                "test", "test", "test", Users);
        departmentRepository.save(department);
        //Then//
        assertNotNull(department);
    }

    @Test
    void findDepartmentById() {
        //Given//
        Department department = new Department(1L, "test", "test", "test",
                "test", "test", "test", Collections.emptyList());
        //When//
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));//define return value
        //Then//
        assertEquals(department, departmentService.findDepartmentById(1L));
    }

    @Test
    void removeDepartment() {
        //Given//
        Department department = new Department(1L, "test", "test", "test",
                "test", "test", "test", Collections.emptyList());
        //When//
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));//define return value
        //Then//
        assertTrue(departmentService.removeDepartment(1L));
    }

    @Test
    void editDepartment() {
        //Given//
        Department oldDepartment = new Department(1L, "test", "test", "test",
                "test", "test", "test", Collections.emptyList());
        Department newDepartment = new Department(2L, "test", "test", "test",
                "test", "test", "test", Collections.emptyList());
        //When//
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(oldDepartment));//define return value
        //Then//
        assertNotNull(departmentService.editDepartment(newDepartment, 1L));
    }
}