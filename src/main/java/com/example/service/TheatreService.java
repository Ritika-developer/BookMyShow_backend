//package com.example.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.model.Theatre;
//import com.example.repository.TheatreRepository;
//
//@Service
//public class TheatreService {
//
//    @Autowired
//    private TheatreRepository theatreRepository;
//
//    public Theatre addTheatre(Theatre theatre) {
//        return theatreRepository.save(theatre);
//    }
//
//    public List<Theatre> getAllTheatres() {
//        return theatreRepository.findAll();
//    }
//
//    public void deleteTheatre(Long id) {
//        theatreRepository.deleteById(id);
//    }
//    
//    public List<Theatre> getTheatreByCity(String city){
//
//        return theatreRepository.findByCity(city);
//
//    }
//}








package com.example.service;

import com.example.model.Theatre;
import com.example.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getAll() {
        return theatreRepository.findAll();
    }

    public Theatre save(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre update(Long id, Theatre theatre) {
        Theatre existing = theatreRepository.findById(id).orElseThrow();
        existing.setName(theatre.getName());
        existing.setCity(theatre.getCity());
        existing.setAddress(theatre.getAddress());
        existing.setScreens(theatre.getScreens());
        existing.setContact(theatre.getContact());
        return theatreRepository.save(existing);
    }

    public void delete(Long id) {
        theatreRepository.deleteById(id);
    }
}