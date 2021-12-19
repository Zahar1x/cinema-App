package ru.mai.zaharix.cinemaapplastest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;
import ru.mai.zaharix.cinemaapplastest.entities.Session;
import ru.mai.zaharix.cinemaapplastest.service.impl.PlacesOfSessionServiceImpl;
import ru.mai.zaharix.cinemaapplastest.service.impl.SessionServiceImpl;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/sessions")
public class SessionsController {

    @Autowired
    private SessionServiceImpl service;

    @Autowired
    private PlacesOfSessionServiceImpl placesOfSessionService;

    @GetMapping("/")
    public ResponseEntity<List<Session>> getAllSessions() {
        try {
            List<Session> sessions = new ArrayList<>(service.findAll());
            if(sessions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable("id") long id) {
        Session session = service.getById(id);

        if (session != null) {
            return new ResponseEntity<>(session, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        try {
            if(service.createNewSession(session)) {
                return new ResponseEntity<>(session, HttpStatus.CREATED);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(@PathVariable("id") long id, @RequestBody Session session) {
        Session session1 = service.getById(id);

        if (session1 != null) {
           session1.setMovie(session.getMovie());
           session1.setDate(session.getDate());
           session1.setHall(session.getHall());
           session1.setCoefficient(session.getCoefficient());
            if(service.createNewSession(session1)) {
                return new ResponseEntity<>(session1, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSession(@PathVariable("id") long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllsessions() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/places")
    public ResponseEntity<List<PlacesOfSession>> getPlacesOfThisSession(@PathVariable("id") long id) {
        try {
            Session session = service.getById(id);
            List<PlacesOfSession> placesOfThisSession = placesOfSessionService.findBySessionId(session.getId());
            return new ResponseEntity<>(placesOfThisSession, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
