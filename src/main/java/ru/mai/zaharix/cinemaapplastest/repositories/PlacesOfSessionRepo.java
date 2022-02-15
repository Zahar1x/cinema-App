package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.zaharix.cinemaapplastest.entities.Place;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;
import ru.mai.zaharix.cinemaapplastest.entities.Ticket;

import java.util.List;

public interface PlacesOfSessionRepo extends JpaRepository<PlacesOfSession, Long> {
    @Query(value = "select p from PlacesOfSession p where p.session.id = :id order by p.id")
    List<PlacesOfSession> findBySessionId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update PlacesOfSession p set p.ticket=:ticket where p.place=:place")
    void updatePlaceOfSession(@Param("ticket") Ticket ticket, @Param("place") Place place);
}
