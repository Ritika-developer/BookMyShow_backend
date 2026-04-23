package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.Movie;
import com.example.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	 private final MovieService movieService;

	    public MovieController(MovieService movieService) {
	        this.movieService = movieService;
	    }

	    @GetMapping
	    public List<Movie> getAll() {
	        return movieService.getAll();
	    }

	    @PostMapping
	    public Movie create(@RequestBody Movie movie) {
	        return movieService.save(movie);
	    }

	    @PutMapping("/{id}")
	    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
	        return movieService.update(id, movie);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        movieService.delete(id);
	    }
}