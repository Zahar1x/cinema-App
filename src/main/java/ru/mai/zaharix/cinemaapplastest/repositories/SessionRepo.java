package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mai.zaharix.cinemaapplastest.entities.Session;

import java.sql.Date;
import java.util.List;

public interface SessionRepo extends JpaRepository<Session, Long> {
}
