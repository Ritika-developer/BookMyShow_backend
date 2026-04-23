//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.Seat;
//import com.example.service.SeatService;
//
//@RestController
//@RequestMapping("/api/seats")
//public class SeatController {
//
//    @Autowired
//    private SeatService seatService;
//
//    @PostMapping
//    public Seat addSeat(@RequestBody Seat seat) {
//        return seatService.addSeat(seat);
//    }
//
//    @GetMapping
//    public List<Seat> getSeats() {
//        return seatService.getSeats();
//    }
//
//    @GetMapping("/show/{showId}")
//    public List<Seat> getSeatsByShow(@PathVariable Long showId) {
//
//        return seatService.getSeatsByShow(showId);
//
//    }
//    
//    @PutMapping("/{id}")
//    public Seat updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
//        return seatService.updateSeat(id, seat);
//    }
//}









package com.example.controller;

import com.example.model.Seat;
import com.example.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "http://localhost:5173")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/show/{showId}")
    public List<Seat> getSeatsByShow(@PathVariable Long showId) {
        return seatService.getSeatsByShowId(showId);
    }

    @PostMapping("/generate/{showId}")
    public List<Seat> generateSeats(@PathVariable Long showId) {
        return seatService.generateSeats(showId);
    }

    @PutMapping("/{seatId}/status")
    public Seat updateSeatStatus(@PathVariable Long seatId, @RequestBody Map<String, String> body) {
        return seatService.updateSeatStatus(seatId, body.get("status"));
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
    }
}