//package com.example.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.model.Seat;
//import com.example.repository.SeatRepository;
//
//@Service
//public class SeatService {
//
//    @Autowired
//    private SeatRepository seatRepository;
//
//    // Add seat
//    public Seat addSeat(Seat seat) {
//        return seatRepository.save(seat);
//    }
//
//    // Get all seats
//    public List<Seat> getSeats() {
//        return seatRepository.findAll();
//    }
//
//    // Get seats by showId
//    public List<Seat> getSeatsByShow(Long showId) {
//        return seatRepository.findByShowId(showId);
//    }
//
//    // Update seat
//    public Seat updateSeat(Long id, Seat seat) {
//
//        Seat existing = seatRepository.findById(id).orElse(null);
//
//        if(existing != null) {
//            existing.setSeatNumber(seat.getSeatNumber());
//            existing.setStatus(seat.getStatus());
//            return seatRepository.save(existing);
//        }
//
//        return null;
//    }
//
//}







package com.example.service;

import com.example.model.Seat;
import com.example.model.Show;
import com.example.repository.SeatRepository;
import com.example.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;

    public SeatService(SeatRepository seatRepository, ShowRepository showRepository) {
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
    }

    public List<Seat> getSeatsByShowId(Long showId) {
        return seatRepository.findByShowId(showId);
    }

    public List<Seat> generateSeats(Long showId) {
        Show show = showRepository.findById(showId).orElseThrow();

        List<Seat> generatedSeats = new ArrayList<>();

        String[] rows = {"A", "B", "C", "D", "E"};
        int seatsPerRow = 10;

        for (String row : rows) {
            for (int i = 1; i <= seatsPerRow; i++) {
                String seatNumber = row + i;

                boolean exists = seatRepository.existsByShowIdAndSeatNumber(showId, seatNumber);
                if (!exists) {
                    Seat seat = new Seat();
                    seat.setSeatNumber(seatNumber);
                    seat.setStatus("AVAILABLE");
                    seat.setShow(show);
                    generatedSeats.add(seat);
                }
            }
        }

        return seatRepository.saveAll(generatedSeats);
    }

    public Seat updateSeatStatus(Long seatId, String status) {
        Seat seat = seatRepository.findById(seatId).orElseThrow();
        seat.setStatus(status);
        return seatRepository.save(seat);
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}