package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.zaharix.cinemaapplastest.entities.HallTypes;

public interface HallTypesRepo extends JpaRepository<HallTypes, Long> {
}
