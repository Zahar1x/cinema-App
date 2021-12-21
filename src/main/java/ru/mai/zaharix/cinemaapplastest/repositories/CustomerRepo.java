package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Override
    List<Customer> findAll();

    Optional<Customer> findByName(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);
}
