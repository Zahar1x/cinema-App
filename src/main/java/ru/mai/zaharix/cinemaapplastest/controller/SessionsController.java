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
    public ResponseEntity<List<Session>> getSessionByCinemaId(@PathVariable("id") long id) {
        List<Session> sessions = service.findAllByCinemaId(id);

        if (sessions != null) {
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
