package ru.mai.zaharix.cinemaapplastest.security.core;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;

import java.util.Collection;
import java.util.Collections;

public class CustomerDetails implements UserDetails {

    private String name;
    private String surname;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomerDetails CustomerToDetails(Customer customer) {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.name = customer.getName();
        customerDetails.surname = customer.getSurname();
        customerDetails.email = customer.getEmail();
        customerDetails.password = customer.getPassword();
        customerDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(customer.getRole()));
        return customerDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
