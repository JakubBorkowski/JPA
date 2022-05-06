package com.github.jakubborkowski.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public User(String description, String firstName, String lastName, String password,
                String userName, List<Payment> payments, List<Department> departments) {
        this.description = description;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.payments = payments;
        this.departments = departments;
    }

    private String description;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Payment> payments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_department",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments = new ArrayList<>();
}