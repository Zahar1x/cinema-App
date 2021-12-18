package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.zaharix.cinemaapplastest.entities.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
