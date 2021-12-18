package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.zaharix.cinemaapplastest.entities.Hall;

public interface HallRepo extends JpaRepository<Hall, Long> {
}
