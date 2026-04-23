//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.Booking;
//import com.example.service.BookingService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bookings")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @PostMapping
//    public Booking bookTicket(@RequestBody Booking booking) {
//        return bookingService.bookTicket(booking);
//    }
//
//    @GetMapping
//    public List<Booking> getAllBookings() {
//        return bookingService.getAllBookings();
//    }
//}









package com.example.controller;

import com.example.model.Booking;
import com.example.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // ✅ CREATE BOOKING
    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }

    // ✅ GET ALL BOOKINGS
    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    // ✅ GET USER BOOKINGS (IMPORTANT for MyBookings page)
    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable Long userId) {
        return bookingService.getByUserId(userId);
    }
    
    
 // ✅ GET BOOKING BY ID (MOST IMPORTANT)
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getById(id);
    }
    
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.delete(id);
        return "Booking deleted successfully";
    }
}
//@RestController
//@RequestMapping("/api/bookings")
//
//public class BookingController {
//
//    private final BookingService bookingService;
//
//    public BookingController(BookingService bookingService) {
//        this.bookingService = bookingService;
//    }
//
//    @GetMapping
//    public List<Booking> getAll() {
//        return bookingService.getAll();
//    }
//}