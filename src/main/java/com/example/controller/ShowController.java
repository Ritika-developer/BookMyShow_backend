//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.Show;
//import com.example.service.ShowService;
//
//@RestController
//@RequestMapping("/api/shows")
//public class ShowController {
//
//    @Autowired
//    private ShowService showService;
//
//    @PostMapping
//    public Show addShow(@RequestBody Show show) {
//        return showService.addShow(show);
//    }
//
//    @GetMapping
//    public List<Show> getShows() {
//        return showService.getAllShows();
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteShow(@PathVariable Long id) {
//        showService.deleteShow(id);
//        return "Show Deleted";
//    }
//}










package com.example.controller;

import com.example.dto.ShowRequest;
import com.example.model.Show;
import com.example.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")

public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getAll() {
        return showService.getAll();
    }

    @GetMapping("/{id}")
    public Show getById(@PathVariable Long id) {
        return showService.getById(id);
    }

    @PostMapping
    public Show create(@RequestBody ShowRequest request) {
        return showService.save(request);
    }

    @PutMapping("/{id}")
    public Show update(@PathVariable Long id, @RequestBody ShowRequest request) {
        return showService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        showService.delete(id);
    }
}