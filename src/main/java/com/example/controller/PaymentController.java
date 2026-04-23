//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.Payment;
//import com.example.service.PaymentService;
//
//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping
//    public Payment makePayment(@RequestBody Payment payment) {
//        return paymentService.processPayment(payment);
//    }
//}









package com.example.controller;

import com.example.model.Payment;
import com.example.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")

public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }
    
    
    
    
    @PostMapping
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }
}