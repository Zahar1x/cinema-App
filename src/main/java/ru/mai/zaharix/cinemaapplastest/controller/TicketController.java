package ru.mai.zaharix.cinemaapplastest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.entities.Ticket;
import ru.mai.zaharix.cinemaapplastest.repositories.CustomerRepo;
import ru.mai.zaharix.cinemaapplastest.repositories.PlacesOfSessionRepo;
import ru.mai.zaharix.cinemaapplastest.security.payload.request.TicketRequest;
import ru.mai.zaharix.cinemaapplastest.security.payload.response.MessageResponse;
import ru.mai.zaharix.cinemaapplastest.service.impl.TicketServiceImpl;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PlacesOfSessionRepo placesOfSessionRepo;

    @PostMapping("/")
    public ResponseEntity<?> createTicket(@RequestBody TicketRequest ticketRequest) {
        try {
            Ticket ticket = new Ticket();
            if (ticketRequest.getPlaceOfSession().getSession().getHall().getId()
                    == ticketRequest.getPlaceOfSession().getPlace().getHall().getId()) {
                ticketRequest.getPlaceOfSession().getSession().setHall(
                        ticketRequest.getPlaceOfSession().getPlace().getHall());
            }

            ticket.setPlacesOfSession(ticketRequest.getPlaceOfSession());
            ticket.setCustomer(getCustomerById(ticketRequest.getCustomer().getEmail()));
            ticketService.createNewTicket(ticket);
            placesOfSessionRepo.updatePlaceOfSession(ticket.getId());
            return new ResponseEntity<>(new MessageResponse("Ticket has been created successfully!"),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MessageResponse("Creation of ticket failed. Check your data"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Customer getCustomerById(String email) {
        return customerRepo.findByEmail(email).get();
    }
}
