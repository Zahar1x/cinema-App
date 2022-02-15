package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;
import ru.mai.zaharix.cinemaapplastest.entities.Ticket;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByCustomer_Id(long id);
}
