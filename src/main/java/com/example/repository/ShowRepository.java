package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

}