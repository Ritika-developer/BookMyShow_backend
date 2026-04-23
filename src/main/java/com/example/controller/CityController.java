package com.example.controller;

import com.example.model.City;
import com.example.repository.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> getAllCities() {
        List<City> cities = cityRepository.findAll();

        System.out.println("CITIES FROM DB: " + cities); // ✅ debug

        return cities;
    }
}