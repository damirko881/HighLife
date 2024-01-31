package com.example.highlife.repositories;

import com.example.highlife.models.Reservation;
import com.example.highlife.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByPodijAndDatum(String podij, Date datum);
    List<Reservation> findByDatum(Date datum);
    List<Reservation> findByPodij(String podij);

    boolean existsByKorisnikAndPodij(User currentUser, String podij);

    boolean existsByKorisnik(User currentUser);
    // Dodajte druge potrebne metode prema vašim zahtjevima
}
