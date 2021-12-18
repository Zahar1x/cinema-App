package ru.mai.zaharix.cinemaapplastest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.zaharix.cinemaapplastest.entities.Cinema;
import ru.mai.zaharix.cinemaapplastest.repositories.CinemaRepo;
import ru.mai.zaharix.cinemaapplastest.service.interfaces.CinemaService;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepo cinemaRepo;

    @Override
    public void addNewCinema(Cinema cinema) {
        cinemaRepo.save(cinema);
    }

    @Override
    public List<Cinema> findAll() {
        return cinemaRepo.findAll();
    }

    @Override
    public Cinema findById(long id) {
        return cinemaRepo.getById(id);
    }

    @Override
    public void deleteAll() {
        cinemaRepo.deleteAll();
    }

    @Override
    public void deleteById(long id) {
        cinemaRepo.deleteById(id);
    }
}
