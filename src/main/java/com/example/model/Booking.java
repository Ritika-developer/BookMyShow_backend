//package com.example.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@Entity
//@Table(name="bookings")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Booking {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonIgnoreProperties({"password", "hibernateLazyInitializer", "handler"})
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "show_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Show show;
//
//    private String seatNumber;
//    private String bookingDate;
//    private Double amount;
//    private String status;
//}







package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "seat_number")
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Show show;

    private Double amount;

    @Column(name = "booking_date")
    private String bookingDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"password", "hibernateLazyInitializer", "handler"})
    private User user;
}