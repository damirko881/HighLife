package com.example.highlife.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User korisnik;

    @Column(name = "podij")
    private String podij;



    @Column(name = "datum")
    private Date datum;

    // Dodajte ostala polja prema potrebi

    public Reservation() {}

    public Reservation(User korisnik, String podij, int brojStolova, Date datum) {
        this.korisnik = korisnik;
        this.podij = podij;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(User korisnik) {
        this.korisnik = korisnik;
    }

    public String getPodij() {
        return podij;
    }

    public void setPodij(String podij) {
        this.podij = podij;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

}
