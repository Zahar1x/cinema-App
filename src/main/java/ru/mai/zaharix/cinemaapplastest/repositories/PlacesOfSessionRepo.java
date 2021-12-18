package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;

public interface PlacesOfSessionRepo extends JpaRepository<PlacesOfSession, Long> {
}
