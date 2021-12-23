package ru.mai.zaharix.cinemaapplastest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.zaharix.cinemaapplastest.entities.Movie;
import ru.mai.zaharix.cinemaapplastest.repositories.MovieRepo;
import ru.mai.zaharix.cinemaapplastest.service.interfaces.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    
    @Autowired
    private MovieRepo movieRepo;

    @Override
    public void addNewMovie(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Movie findById(long id) {
        return movieRepo.findById(id).get();
    }

    @Override
    public void deleteAll() {
        movieRepo.deleteAll();
    }

    @Override
    public void deleteById(long id) {
        movieRepo.deleteById(id);
    }
}
