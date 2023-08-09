package com.rungroop.web.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.repository.ClubRepository;
import com.rungroop.web.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService{
    private ClubRepository clubRepository;
    
    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
    	this.clubRepository = clubRepository;
    }
	@Override
	public List<ClubDto> findAllClubs() {
	    List<Club> clubs = clubRepository.findAll();
	    return clubs.stream().map((club)->mapToClubDto(club)).collect(Collectors.toList());
	}
	
    private ClubDto mapToClubDto(Club club) {
    	ClubDto clubDto = ClubDto.builder()
    			.id(club.getId())
    			.title(club.getTitle())
    			.photoURL(club.getPhotoURL())
    			.content(club.getContent())
    			.createdOn(club.getCreatedOn())
    			.updatedOn(club.getUpdatedOn())
    			.build();
       return clubDto;
    }
    @Override
    public Club saveClub(ClubDto clubDto) {
    	Club club = mapToClub(clubDto);
    	return clubRepository.save(club);
    }
    
    @Override
    public ClubDto findClubById(long clubId){
    	Club club = clubRepository.findById(clubId).get();
    	return mapToClubDto(club);
    	
    }
	@Override
	public void updateClub(ClubDto clubDto) {
		Club club = mapToClub(clubDto);
		clubRepository.save(club);
	}
	private Club mapToClub(ClubDto club) {
		Club clubDto = Club.builder()
				.id(club.getId())
				.title(club.getTitle())
				.photoURL(club.getPhotoURL())
				.content(club.getContent())
				.build();
		return clubDto;
	}
	@Override
	public void delete(long clubId) {
		clubRepository.deleteById(clubId);
	}
	
	
	@Override
	public List<ClubDto> searchClubs(String query) {
		List<Club> clubs = clubRepository.searchClubs(query);
		return clubs.stream().map(club-> mapToClubDto(club)).collect(Collectors.toList());
	}
	
}
