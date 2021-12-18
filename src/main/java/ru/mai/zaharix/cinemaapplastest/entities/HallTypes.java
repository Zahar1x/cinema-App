package ru.mai.zaharix.cinemaapplastest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hall_types")
public class HallTypes {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "coefficient", nullable = false)
    private float coefficient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }
}
