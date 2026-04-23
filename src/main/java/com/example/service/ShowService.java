//package com.example.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.model.Movie;
//import com.example.model.Show;
//import com.example.model.Theatre;
//import com.example.repository.MovieRepository;
//import com.example.repository.ShowRepository;
//import com.example.repository.TheatreRepository;
//
//@Service
//public class ShowService {
//
//    @Autowired
//    private ShowRepository showRepository;
//
//    @Autowired
//    private MovieRepository movieRepository;
//
//    @Autowired
//    private TheatreRepository theatreRepository;
//
//    public Show addShow(Show show) {
//
//        Movie movie = movieRepository.findById(show.getMovie().getId()).orElse(null);
//        Theatre theatre = theatreRepository.findById(show.getTheatre().getId()).orElse(null);
//
//        show.setMovie(movie);
//        show.setTheatre(theatre);
//
//        return showRepository.save(show);
//    }
//
//    public List<Show> getAllShows() {
//        return showRepository.findAll();
//    }
//
//    // ✅ Add this method
//    public void deleteShow(Long id) {
//        showRepository.deleteById(id);
//    }
//}







package com.example.service;

import com.example.dto.ShowRequest;
import com.example.model.Movie;
import com.example.model.Show;
import com.example.model.Theatre;
import com.example.repository.MovieRepository;
import com.example.repository.ShowRepository;
import com.example.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;

    public ShowService(
            ShowRepository showRepository,
            MovieRepository movieRepository,
            TheatreRepository theatreRepository
    ) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

    public List<Show> getAll() {
        return showRepository.findAll();
    }

    public Show save(ShowRequest request) {
        Movie movie = movieRepository.findById(request.getMovieId()).orElseThrow();
        Theatre theatre = theatreRepository.findById(request.getTheatreId()).orElseThrow();

        Show show = new Show();
        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setScreen(request.getScreen());
        show.setShowDate(request.getShowDate());
        show.setShowTime(request.getShowTime());
        show.setTicketPrice(request.getTicketPrice());
        show.setAvailableSeats(request.getAvailableSeats());

        return showRepository.save(show);
    }

    public Show update(Long id, ShowRequest request) {
        Show existing = showRepository.findById(id).orElseThrow();
        Movie movie = movieRepository.findById(request.getMovieId()).orElseThrow();
        Theatre theatre = theatreRepository.findById(request.getTheatreId()).orElseThrow();

        existing.setMovie(movie);
        existing.setTheatre(theatre);
        existing.setScreen(request.getScreen());
        existing.setShowDate(request.getShowDate());
        existing.setShowTime(request.getShowTime());
        existing.setTicketPrice(request.getTicketPrice());
        existing.setAvailableSeats(request.getAvailableSeats());

        return showRepository.save(existing);
    }
    
    public Show getById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found with id: " + id));
    }

    public void delete(Long id) {
        showRepository.deleteById(id);
    }
}


