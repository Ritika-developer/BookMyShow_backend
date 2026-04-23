package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
	 List<Theatre> findByCity(String city);
}