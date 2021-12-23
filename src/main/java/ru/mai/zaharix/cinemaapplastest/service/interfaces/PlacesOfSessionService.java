package ru.mai.zaharix.cinemaapplastest.service.interfaces;

import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;

import java.util.List;

public interface PlacesOfSessionService {

    List<PlacesOfSession> findAll();

    PlacesOfSession getById(long id);

    boolean isFree(PlacesOfSession placesOfSession);

    List<PlacesOfSession> findBySessionId(long id);
}
