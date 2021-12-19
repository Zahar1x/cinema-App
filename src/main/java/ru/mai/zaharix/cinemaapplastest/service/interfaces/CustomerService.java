package ru.mai.zaharix.cinemaapplastest.service.interfaces;

import ru.mai.zaharix.cinemaapplastest.entities.Customer;

import java.util.List;

public interface CustomerService {
    void addNewCustomer(Customer customer);

    List<Customer> findAll();

    Customer getById(long id);

    void deleteById(long id);

    void deleteAll();


}
