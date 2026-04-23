//package com.example.controller;
//
//import com.example.repository.*;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/dashboard")
//public class DashboardController {
//
//    private final MovieRepository movieRepository;
//    private final TheatreRepository theatreRepository;
//    private final ShowRepository showRepository;
//    private final BookingRepository bookingRepository;
//    private final UserRepository userRepository;
//    private final PaymentRepository paymentRepository;
//
//    public DashboardController(
//            MovieRepository movieRepository,
//            TheatreRepository theatreRepository,
//            ShowRepository showRepository,
//            BookingRepository bookingRepository,
//            UserRepository userRepository,
//            PaymentRepository paymentRepository
//    ) {
//        this.movieRepository = movieRepository;
//        this.theatreRepository = theatreRepository;
//        this.showRepository = showRepository;
//        this.bookingRepository = bookingRepository;
//        this.userRepository = userRepository;
//        this.paymentRepository = paymentRepository;
//    }
//
//    @GetMapping("/stats")
//    public Map<String, Object> getStats() {
//        Map<String, Object> stats = new HashMap<>();
//        stats.put("totalMovies", movieRepository.count());
//        stats.put("totalTheatres", theatreRepository.count());
//        stats.put("totalShows", showRepository.count());
//        stats.put("totalBookings", bookingRepository.count());
//        stats.put("totalUsers", userRepository.count());
//        stats.put("totalRevenue", paymentRepository.findAll().stream().mapToDouble(p -> p.getAmount() == null ? 0 : p.getAmount()).sum());
//        return stats;
//    }
//}











package com.example.controller;

import com.example.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;

    public DashboardController(
            MovieRepository movieRepository,
            TheatreRepository theatreRepository,
            ShowRepository showRepository,
            BookingRepository bookingRepository,
            UserRepository userRepository,
            PaymentRepository paymentRepository
    ) {
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/stats")
    public Map<String, Object> getStats() {

        Map<String, Object> stats = new HashMap<>();

        stats.put("totalMovies", movieRepository.count());
        stats.put("totalTheatres", theatreRepository.count());
        stats.put("totalShows", showRepository.count());
        stats.put("totalBookings", bookingRepository.count());
        stats.put("totalUsers", userRepository.count());

        Double revenue = paymentRepository.getTotalRevenue();
        stats.put("totalRevenue", revenue != null ? revenue : 0);

        return stats;
    }
}