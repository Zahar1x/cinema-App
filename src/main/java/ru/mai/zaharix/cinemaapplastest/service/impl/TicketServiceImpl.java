package ru.mai.zaharix.cinemaapplastest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.zaharix.cinemaapplastest.entities.Ticket;
import ru.mai.zaharix.cinemaapplastest.repositories.TicketRepo;
import ru.mai.zaharix.cinemaapplastest.service.interfaces.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public void createNewTicket(Ticket ticket) {
        ticketRepo.save(ticket);
    }

    @Override
    public List<Ticket> findAllByCustomerId(long id) {
        return ticketRepo.findAllByCustomer_Id(id);
    }
}
