package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mai.zaharix.cinemaapplastest.entities.Session;

import java.sql.Date;
import java.util.List;

public interface SessionRepo extends JpaRepository<Session, Long> {

    @Query(value = "select s from Session s where s.hall.cinema.id = :id")
    List<Session> findAllByCinemaId(@Param("id") long id);
}
