package ru.mai.zaharix.cinemaapplastest.entities;

import javax.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "row", nullable = false)
    private int row;

    @Column(name = "place", nullable = false)
    private int place;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
