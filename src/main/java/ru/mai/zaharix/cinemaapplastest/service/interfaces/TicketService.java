package ru.mai.zaharix.cinemaapplastest.service.interfaces;

import ru.mai.zaharix.cinemaapplastest.entities.Ticket;

import java.util.List;

public interface TicketService {
    void createNewTicket(Ticket ticket);

    List<Ticket> findAllByCustomerId(long id);
}
