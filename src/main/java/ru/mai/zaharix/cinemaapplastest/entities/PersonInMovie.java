//package ru.mai.zaharix.cinemaapplastest.entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "person_in_movie")
//public class PersonInMovie {
//
//    @Id
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "movie_id", nullable = false)
//    private Movie movie;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id", nullable = false)
//    private Person person;
//
//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//}
