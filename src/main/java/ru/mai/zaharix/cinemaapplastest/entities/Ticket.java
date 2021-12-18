package ru.mai.zaharix.cinemaapplastest.entities;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "check_id", nullable = false)
    private Check check;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_of_session_id", nullable = false)
    private PlacesOfSession placesOfSession;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public PlacesOfSession getPlacesOfSession() {
        return placesOfSession;
    }

    public void setPlacesOfSession(PlacesOfSession placesOfSession) {
        this.placesOfSession = placesOfSession;
    }
}

