package com.github.jakubborkowski.jpa;

import com.github.jakubborkowski.jpa.model.Department;
import com.github.jakubborkowski.jpa.repository.DepartmentRepository;
import com.github.jakubborkowski.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@SpringBootApplication
//@EnableJpaRepositories("com.github.jakubborkowski.jpa.repository")
//@ComponentScan(basePackages = "com.github.jakubborkowski.jpa.service")
//@EntityScan(basePackages = "com.github.jakubborkowski.jpa.model")
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);

		//Department department = new Department("1","1","1","1","1", "1");
		//@Autowired
		//DepartmentService departmentService;
		//departmentService.addNewDepartment("1","1","1","1","1", "1", new ArrayList<>());
	}

}
