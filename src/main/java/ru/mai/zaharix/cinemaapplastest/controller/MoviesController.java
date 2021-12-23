package ru.mai.zaharix.cinemaapplastest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mai.zaharix.cinemaapplastest.entities.Movie;
import ru.mai.zaharix.cinemaapplastest.service.impl.MovieServiceImpl;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            List<Movie> movies = new ArrayList<>(movieService.findAll());
            if(movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id) {
        Movie Movie = movieService.findById(id);

        if (Movie != null) {
            return new ResponseEntity<>(Movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
