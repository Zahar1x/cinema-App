package ru.mai.zaharix.cinemaapplastest.security.payload.request;

import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.entities.PlacesOfSession;

public class TicketRequest {
    private PlacesOfSession placeOfSession;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PlacesOfSession getPlaceOfSession() {
        return placeOfSession;
    }

    public void setPlaceOfSession(PlacesOfSession placeOfSession) {
        this.placeOfSession = placeOfSession;
    }
}
