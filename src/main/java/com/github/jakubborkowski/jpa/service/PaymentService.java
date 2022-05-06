package com.github.jakubborkowski.jpa.service;

import com.github.jakubborkowski.jpa.model.Payment;
import com.github.jakubborkowski.jpa.model.User;
import com.github.jakubborkowski.jpa.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserService userService;

    public Payment addNewPayment(float bonus, String dateOfPayment, float pay, Long userId) {
        User user = userService.findById(userId);
        LocalDate date = LocalDate.parse(dateOfPayment);
        if(user != null && date != null) {
            Payment payment = new Payment(bonus, date, pay, user);
            paymentRepository.save(payment);
            return payment;
        } else {
            return null;
        }
    }

    public Payment findById(Long paymentId) {
        if(paymentRepository.findById(paymentId).isPresent()){
            return paymentRepository.findById(paymentId).get();
        } else {
            return null;
        }
    }

    public boolean removePayment(Long paymentId) {
        Payment payment = findById(paymentId);
        if(payment != null) {
            paymentRepository.delete(payment);
            return true;
        } else {
            return false;
        }
    }

    public Payment editPayment(Payment newPayment, Long oldPaymentId) {
        Payment oldPayment = findById(oldPaymentId);
        if(oldPayment != null && newPayment != null) {
            oldPayment.setBonus(newPayment.getBonus());
            oldPayment.setDateOfPayment(newPayment.getDateOfPayment());
            oldPayment.setPay(newPayment.getPay());
            oldPayment.setUser(newPayment.getUser());
            paymentRepository.save(oldPayment);
            return oldPayment;
        } else {
            return null;
        }
    }

}
