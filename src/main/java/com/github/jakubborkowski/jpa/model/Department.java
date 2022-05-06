package com.github.jakubborkowski.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Department")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Department(String address, String departmentName, String description,
                      String mainMail, String mainPhone, String mainWWW, List<User> users) {
        this.address = address;
        this.departmentName = departmentName;
        this.description = description;
        this.mainMail = mainMail;
        this.mainPhone = mainPhone;
        this.mainWWW = mainWWW;
        this.users = users;
    }

    private String address;
    private String departmentName;
    private String description;
    private String mainMail;
    private String mainPhone;
    private String mainWWW;

    @ManyToMany(
            mappedBy = "departments"
    )
    private List<User> users;

}
