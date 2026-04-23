//package com.example.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.model.Seat;
//
//public interface SeatRepository extends JpaRepository<Seat, Long> {
//	List<Seat> findByShowId(Long showId);
//}






package com.example.repository;

import com.example.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowId(Long showId);
    boolean existsByShowIdAndSeatNumber(Long showId, String seatNumber);
}