package ru.mai.zaharix.cinemaapplastest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Override
    List<Customer> findAll();
}
