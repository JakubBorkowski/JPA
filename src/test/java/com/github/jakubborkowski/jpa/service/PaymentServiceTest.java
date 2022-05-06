package com.github.jakubborkowski.jpa.service;

import com.github.jakubborkowski.jpa.model.Payment;
import com.github.jakubborkowski.jpa.model.User;
import com.github.jakubborkowski.jpa.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    void addNewPayment() {
        //Given//
        User user = new User(1L, "test", "test", "test",
                "test", "test", new ArrayList<>(), new ArrayList<>());
        //When//
        when(userService.findById(1L)).thenReturn(user);//define return value
        //Then//
        assertNotNull(paymentService.addNewPayment(50.0f, LocalDate.now().toString(), 50.0f, 1L));
    }

    @Test
    void findById() {
        //Given//
        Payment payment = new Payment(1L, 50.0f, LocalDate.now(), 50.0f, null);
        //When//
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));//define return value
        //Then//
        assertEquals(payment, paymentService.findById(1L));
    }

    @Test
    void removePayment() {
        //Given//
        Payment payment = new Payment(1L, 50.0f, LocalDate.now(), 50.0f, null);
        //When//
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));//define return value
        //Then//
        assertTrue(paymentService.removePayment(1L));
    }

    @Test
    void editPayment() {
        //Given//
        Payment oldPayment = new Payment(1L, 50.0f, LocalDate.now(), 50.0f, null);
        Payment newPayment = new Payment(2L, 50.0f, LocalDate.now(), 50.0f, null);
        //When//
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(oldPayment));//define return value
        //Then//
        assertNotNull(paymentService.editPayment(newPayment, 1L));
    }
}