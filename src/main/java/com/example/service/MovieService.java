//package com.example.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.model.Movie;
//import com.example.repository.MovieRepository;
//
//@Service
//public class MovieService {
//
//    @Autowired
//    private MovieRepository movieRepository;
//
//    public Movie addMovie(Movie movie) {
//        return movieRepository.save(movie);
//    }
//
//    public List<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }
//
//    public void deleteMovie(Long id) {
//        movieRepository.deleteById(id);
//    }
//}











package com.example.service;

import com.example.model.Movie;
import com.example.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Long id, Movie movie) {
        Movie existing = movieRepository.findById(id).orElseThrow();
        existing.setTitle(movie.getTitle());
        existing.setGenre(movie.getGenre());
        existing.setLanguage(movie.getLanguage());
        existing.setDuration(movie.getDuration());
        existing.setRating(movie.getRating());
        existing.setPosterUrl(movie.getPosterUrl());
        return movieRepository.save(existing);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}