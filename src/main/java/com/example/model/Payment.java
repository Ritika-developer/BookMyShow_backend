//package com.example.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "payments")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Payment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "booking_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Booking booking;
//
//    private Double amount;
//    private String paymentMethod;
//    private String transactionId;
//    private String status;
//}












package com.example.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String status;

    @OneToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Booking booking;

    @Column(name = "transaction_id")
    private String transactionId;
}