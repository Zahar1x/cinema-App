package ru.mai.zaharix.cinemaapplastest.service.interfaces;

import ru.mai.zaharix.cinemaapplastest.entities.Movie;

import java.util.List;

public interface MovieService {

    void addNewMovie(Movie movie);

    List<Movie> findAll();

    Movie findById(long id);

    void deleteAll();

    void deleteById(long id);

}
