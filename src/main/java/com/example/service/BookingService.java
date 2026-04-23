//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.model.Booking;
//import com.example.model.Show;
//import com.example.repository.BookingRepository;
//import com.example.repository.ShowRepository;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private ShowRepository showRepository;
//
//    public Booking bookTicket(Booking booking) {
//
//        Show show = showRepository
//                .findById(booking.getShow().getId())
//                .orElse(null);
//
//        booking.setShow(show);
//        booking.setBookingTime(LocalDateTime.now());
//
//        return bookingRepository.save(booking);
//    }
//
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//}













package com.example.service;
//
//import com.example.model.Booking;
//import com.example.repository.BookingRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookingService {
//
//    private final BookingRepository bookingRepository;
//
//    public BookingService(BookingRepository bookingRepository) {
//        this.bookingRepository = bookingRepository;
//    }
//
//    public List<Booking> getAll() {
//        return bookingRepository.findAll();
//    }
//}




import org.springframework.stereotype.Service;

import com.example.model.Booking;
import com.example.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // ✅ SAVE BOOKING
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    // ✅ GET ALL
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    // ✅ GET BY USER
    public List<Booking> getByUserId(Long userId) {
        return bookingRepository.findByUser_Id(userId);
    }
    
    public Booking getById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
    
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}