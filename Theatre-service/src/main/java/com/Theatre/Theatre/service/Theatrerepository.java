package com.Theatre.Theatre.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Theatrerepository extends JpaRepository<Theatre, Long> {
    Theatre findByName(String name);
   

  
  
    List<Theatre> findByLocationid(long locationid);
  


}
