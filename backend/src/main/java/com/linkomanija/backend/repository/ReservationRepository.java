package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  List<Reservation> findByUserClientId(Long user_client_id);
  List<Reservation> findBySessionId(Long session_id);
}
