package ru.mai.zaharix.cinemaapplastest.security.payload.request;

import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;

public class TicketRequest {
    private long place_id;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(long place_id) {
        this.place_id = place_id;
    }
}
