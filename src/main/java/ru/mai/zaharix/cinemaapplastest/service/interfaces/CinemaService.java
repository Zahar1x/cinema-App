package ru.mai.zaharix.cinemaapplastest.service.interfaces;

import ru.mai.zaharix.cinemaapplastest.entities.Cinema;

import java.util.List;

public interface CinemaService {
    void addNewCinema(Cinema cinema);

    List<Cinema> findAll();

    Cinema findById(long id);

    void deleteAll();

    void deleteById(long id);

}
