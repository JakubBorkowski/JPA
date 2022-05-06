package com.github.jakubborkowski.jpa.repository;

import com.github.jakubborkowski.jpa.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
