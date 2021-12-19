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

    @PostMapping("/add")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            movieService.addNewMovie(movie);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        Movie movie1 = movieService.findById(id);

        if (movie1 != null) {
            movie1.setAbout(movie.getAbout());
            movie1.setName(movie.getName());
            movie1.setAgeRating(movie.getAgeRating());
            movie1.setDuration(movie.getDuration());
            movie1.setGenre(movie.getGenre());
            movie1.setLanguage(movie.getLanguage());
            movie1.setYear(movie.getYear());
            movieService.addNewMovie(movie1);
            return new ResponseEntity<>(movie1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
        try {
            movieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllMovies() {
        try {
            movieService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
