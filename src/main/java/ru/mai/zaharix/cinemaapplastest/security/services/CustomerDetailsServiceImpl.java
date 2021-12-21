package ru.mai.zaharix.cinemaapplastest.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.repositories.CustomerRepo;

@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = customerRepo.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return CustomerDetailsImpl.build(user);
    }
}
