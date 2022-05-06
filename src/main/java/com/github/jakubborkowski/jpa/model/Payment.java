package com.github.jakubborkowski.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Payment")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Payment(Float bonus, LocalDate dateOfPayment, float pay, User user) {
        this.bonus = bonus;
        this.dateOfPayment = dateOfPayment;
        this.pay = pay;
        this.user = user;
    }

    private Float bonus;
    private LocalDate dateOfPayment;
    private float pay;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
