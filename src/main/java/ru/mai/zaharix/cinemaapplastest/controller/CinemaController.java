package ru.mai.zaharix.cinemaapplastest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mai.zaharix.cinemaapplastest.entities.Cinema;
import ru.mai.zaharix.cinemaapplastest.service.impl.CinemaServiceImpl;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/cinema")
public class CinemaController {

    @Autowired
    private CinemaServiceImpl cinemaService;

    @GetMapping("/")
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        try {
            List<Cinema> cinemas = new ArrayList<>(cinemaService.findAll());
            if(cinemas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cinemas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable("id") long id) {
        Cinema cinema = cinemaService.findById(id);

        if (cinema != null) {
            return new ResponseEntity<>(cinema, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
