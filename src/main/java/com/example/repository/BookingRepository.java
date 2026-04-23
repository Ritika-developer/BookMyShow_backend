package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByUser_Id(Long userId);

}