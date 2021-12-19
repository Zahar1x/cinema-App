package ru.mai.zaharix.cinemaapplastest.service.interfaces;

import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;

import java.util.List;

public interface PlacesOfSessionService {
    void createPlacesOfSession(PlacesOfSession placesOfSession);

    List<PlacesOfSession> findAll();

    PlacesOfSession getById(long id);

    void deleteById(long id);

    void deleteAll();

    boolean isFree(PlacesOfSession placesOfSession);

    List<PlacesOfSession> findBySessionId(long id);
}
