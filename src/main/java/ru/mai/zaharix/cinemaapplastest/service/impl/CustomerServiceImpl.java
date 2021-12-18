package ru.mai.zaharix.cinemaapplastest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.repositories.CustomerRepo;
import ru.mai.zaharix.cinemaapplastest.service.interfaces.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void addNewCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getById(long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        customerRepo.deleteAll();
    }
}
