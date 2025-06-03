package com.seat_service.seat_service;

import java.util.List;

import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<SEAT, Long> {
   
  List<SEAT> findByscreeningid(Long screeningid);

   


}
