package ru.mai.zaharix.cinemaapplastest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.entities.Place;
import ru.mai.zaharix.cinemaapplastest.entities.Ticket;
import ru.mai.zaharix.cinemaapplastest.repositories.CustomerRepo;
import ru.mai.zaharix.cinemaapplastest.repositories.PlaceRepo;
import ru.mai.zaharix.cinemaapplastest.repositories.PlacesOfSessionRepo;
import ru.mai.zaharix.cinemaapplastest.security.payload.request.TicketRequest;
import ru.mai.zaharix.cinemaapplastest.security.payload.response.MessageResponse;
import ru.mai.zaharix.cinemaapplastest.service.impl.TicketServiceImpl;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PlaceRepo placeRepo;

    @Autowired
    private PlacesOfSessionRepo placesOfSessionRepo;

    @PostMapping("/")
    public ResponseEntity<?> createTicket(@RequestBody TicketRequest ticketRequest) {
        try {
            Ticket ticket = new Ticket();
            ticket.setCustomer(getCustomerById(ticketRequest.getCustomer().getEmail()));
            ticketService.createNewTicket(ticket);
            placesOfSessionRepo.updatePlaceOfSession(ticket, getPlaceById(ticketRequest.getPlace_id()));
            return new ResponseEntity<>(new MessageResponse("Ticket has been created successfully!"),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MessageResponse("Creation of ticket failed. Check your data"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Ticket>> getAllTicketsByCustomerId(@PathVariable("id") long id) {
        try {

            List<Ticket> ticketList = ticketService.findAllByCustomerId(id);

            if (ticketList != null) {
                return new ResponseEntity<>(ticketList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    private Customer getCustomerById(String email) {
        return customerRepo.findByEmail(email).get();
    }

    private Place getPlaceById(long place_id) {
        return placeRepo.findById(place_id).get();
    }
}
