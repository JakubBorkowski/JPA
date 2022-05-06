package com.github.jakubborkowski.jpa.service;

import com.github.jakubborkowski.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Loads example date to database
 */
@Service
public class InitDataLoaderService {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    UserService userService;

    @PostConstruct
    public void initialize() {
        User user = userService.addNewUser("Description","First name",
                "Last name", "password","User name");
        paymentService.addNewPayment(50.0f, String.valueOf(LocalDate.now()), 50.0f, user.getId());
        departmentService.addNewDepartment("Address","Department","Description",
                "department@mail.com","123 456 789", "www.department.com", new ArrayList<>());
    }
}
