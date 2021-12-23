package ru.mai.zaharix.cinemaapplastest.service.interfaces;

import ru.mai.zaharix.cinemaapplastest.entities.Session;

import java.util.List;

public interface SessionService {
    boolean createNewSession(Session session);

    List<Session> findAll();

    Session getById(long id);

    List<Session> findAllByCinemaId(long id);
}
