//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.model.Payment;
//import com.example.model.Booking;
//import com.example.repository.PaymentRepository;
//import com.example.repository.BookingRepository;
//
//@Service
//public class PaymentService {
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    public Payment processPayment(Payment payment) {
//
//        Booking booking = bookingRepository
//                .findById(payment.getBooking().getId())
//                .orElse(null);
//
//        payment.setBooking(booking);
//
//        payment.setStatus("SUCCESS");
//
//        return paymentRepository.save(payment);
//    }
//}









package com.example.service;

import com.example.model.Payment;
import com.example.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
    
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}