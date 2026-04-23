//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.Theatre;
//import com.example.service.TheatreService;
//
//@RestController
//@RequestMapping("/api/theatres")
//public class TheatreController {
//
//    @Autowired
//    private TheatreService theatreService;
//
//    @PostMapping
//    public Theatre addTheatre(@RequestBody Theatre theatre) {
//        return theatreService.addTheatre(theatre);
//    }
//
//    @GetMapping
//    public List<Theatre> getTheatres() {
//        return theatreService.getAllTheatres();
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteTheatre(@PathVariable Long id) {
//        theatreService.deleteTheatre(id);
//        return "Theatre Deleted";
//    }
//    
//    @GetMapping("/city/{city}")
//    public List<Theatre> getTheatresByCity(@PathVariable String city){
//
//        return theatreService.getTheatreByCity(city);
//
//    }
//}







package com.example.controller;

import com.example.model.Theatre;
import com.example.service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")

public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping
    public List<Theatre> getAll() {
        return theatreService.getAll();
    }

    @PostMapping
    public Theatre create(@RequestBody Theatre theatre) {
        return theatreService.save(theatre);
    }

    @PutMapping("/{id}")
    public Theatre update(@PathVariable Long id, @RequestBody Theatre theatre) {
        return theatreService.update(id, theatre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        theatreService.delete(id);
    }
}