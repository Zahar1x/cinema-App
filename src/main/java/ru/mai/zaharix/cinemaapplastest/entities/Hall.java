package ru.mai.zaharix.cinemaapplastest.entities;

import javax.persistence.*;

@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hall_type_id")
    private HallTypes hall_type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public HallTypes getHall_type() {
        return hall_type;
    }

    public void setHall_type(HallTypes hall_type) {
        this.hall_type = hall_type;
    }
}
