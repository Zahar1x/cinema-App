package ru.mai.zaharix.cinemaapplastest.security.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.service.impl.CustomerServiceImpl;

@Component
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    CustomerServiceImpl customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.getByEmail(username);
        return CustomerDetails.CustomerToDetails(customer);
    }
}
