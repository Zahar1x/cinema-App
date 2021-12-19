package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;

import java.util.List;

public interface PlacesOfSessionRepo extends JpaRepository<PlacesOfSession, Long> {
    @Query(value = "select p from PlacesOfSession p where p.session.id = :#{id}")
    List<PlacesOfSession> findBySessionId(@Param("id") long id);
}
