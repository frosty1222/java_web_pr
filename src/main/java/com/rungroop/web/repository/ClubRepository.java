package com.rungroop.web.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rungroop.web.models.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
  Optional<Club> findByTitle(String Url);
  @Query("SELECT c from Club c WHERE c.title like CONCAT('%', :title, '%')")
  List<Club> searchClubs(String title);
  List<Club> findAllByTitleContains(String title);
}
