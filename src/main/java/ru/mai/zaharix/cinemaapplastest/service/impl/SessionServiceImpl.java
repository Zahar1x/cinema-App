package ru.mai.zaharix.cinemaapplastest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.zaharix.cinemaapplastest.entities.Movie;
import ru.mai.zaharix.cinemaapplastest.entities.Session;
import ru.mai.zaharix.cinemaapplastest.repositories.MovieRepo;
import ru.mai.zaharix.cinemaapplastest.repositories.SessionRepo;
import ru.mai.zaharix.cinemaapplastest.service.interfaces.SessionService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepo sessionRepo;

    @Override
    public boolean createNewSession(Session session) {
        if (checkSession(session)) {
            sessionRepo.save(session);
            return true;
        }
        return false;
    }

    @Override
    public List<Session> findAll() {
        return sessionRepo.findAll();
    }

    @Override
    public Session getById(long id) {
        return sessionRepo.getById(id);
    }

    @Override
    public void deleteById(long id) {
        sessionRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        sessionRepo.deleteAll();
    }


    private boolean checkSession(Session session) {
        List<Session> sessions = sessionRepo.findAll();
        long movieDuration = session.getMovie().getDuration() * 60000L;

        for(int i = 0; i < sessions.size(); i++) {
            Session sessionI = sessions.get(i);
            for(int j = 0; j < sessions.size(); j++) {
                Session sessionJ = sessions.get(j);
                if ((sessionI.getDate().getTime() - sessionJ.getDate().getTime()) > movieDuration) {
                    return true;
                }
            }
        }
        return false;
    }
}
