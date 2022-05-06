package com.github.jakubborkowski.jpa.service;

import com.github.jakubborkowski.jpa.model.Department;
import com.github.jakubborkowski.jpa.model.User;
import com.github.jakubborkowski.jpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addNewDepartment(String address, String departmentName, String description, String mainMail, String mainPhone, String mainWWW, List<User> users) {
        Department department = new Department(address, departmentName, description, mainMail, mainPhone, mainWWW, users);
        departmentRepository.save(department);
        return department;
    }

    public Department findDepartmentById(Long departmentId) {
        if(departmentRepository.findById(departmentId).isPresent()){
            return departmentRepository.findById(departmentId).get();
        } else {
            return null;
        }
    }

    public boolean removeDepartment(Long departmentId) {
        Department department = findDepartmentById(departmentId);
        if (department != null) {
            departmentRepository.delete(department);
            return true;
        } else {
            return false;
        }
    }

    public Department editDepartment(Department newDepartment, Long oldDepartmentId) {
        Department oldDepartment = findDepartmentById(oldDepartmentId);
        if (oldDepartment != null && newDepartment != null) {
            oldDepartment.setAddress(newDepartment.getAddress());
            oldDepartment.setDepartmentName(newDepartment.getDepartmentName());
            oldDepartment.setDescription(newDepartment.getDescription());
            oldDepartment.setMainMail(newDepartment.getMainMail());
            oldDepartment.setMainPhone(newDepartment.getMainPhone());
            oldDepartment.setMainWWW(newDepartment.getMainWWW());
            oldDepartment.setUsers(newDepartment.getUsers());
            departmentRepository.save(oldDepartment);
            return oldDepartment;
        } else {
            return null;
        }
    }
}
