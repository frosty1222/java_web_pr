package com.rungroop.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;

public interface ClubService {
   List<ClubDto> findAllClubs();
   
   Club saveClub(ClubDto club);
   
   ClubDto findClubById(long clubId);

   void updateClub(ClubDto club);

   void delete(long clubId);
   
   /**
    * Search for clubs based on a query.
    *
    * @param query The search query.
    * @return List of ClubDto objects matching the search query.
    */
   List<ClubDto> searchClubs(String query);
}
