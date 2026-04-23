//package com.example.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.model.Payment;
//
//public interface PaymentRepository extends JpaRepository<Payment, Long> {
//
//}








package com.example.repository;

import com.example.model.Payment;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.status = 'SUCCESS'")
    Double getTotalRevenue();
}