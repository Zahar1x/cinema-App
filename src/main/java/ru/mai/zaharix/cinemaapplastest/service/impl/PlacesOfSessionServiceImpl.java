package ru.mai.zaharix.cinemaapplastest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;
import ru.mai.zaharix.cinemaapplastest.repositories.PlacesOfSessionRepo;
import ru.mai.zaharix.cinemaapplastest.service.interfaces.PlacesOfSessionService;

import java.util.List;

@Service
public class PlacesOfSessionServiceImpl implements PlacesOfSessionService {

    @Autowired
    private PlacesOfSessionRepo placesOfSessionRepo;

    @Override
    public List<PlacesOfSession> findAll() {
        return placesOfSessionRepo.findAll();
    }

    @Override
    public PlacesOfSession getById(long id) {
        return placesOfSessionRepo.findById(id).get();
    }

    @Override
    public boolean isFree(PlacesOfSession placesOfSession) {
        return placesOfSession.getTicket() != null;
    }

    @Override
    public List<PlacesOfSession> findBySessionId(long id) {
        return placesOfSessionRepo.findBySessionId(id);
    }
}
