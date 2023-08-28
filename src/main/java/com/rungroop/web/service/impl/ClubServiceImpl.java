package com.rungroop.web.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.rungroop.web.models.UserEntity;
import com.rungroop.web.repository.UserRepository;
import com.rungroop.web.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.mapper.ClubMapper;
import com.rungroop.web.models.Club;
import com.rungroop.web.repository.ClubRepository;
import com.rungroop.web.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService{
    private ClubRepository clubRepository;

	private UserRepository userRepository;
    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository,UserRepository userRepository) {
    	this.clubRepository = clubRepository;
		this.userRepository  = userRepository;
    }
	@Override
	public List<ClubDto> findAllClubs() {
	    List<Club> clubs = clubRepository.findAll();
	    return clubs.stream().map((club)->ClubMapper.mapToClubDto(club)).collect(Collectors.toList());
	}
	
    @Override
    public Club saveClub(ClubDto clubDto) {
		String username = SecurityUtil.getSessionUser();
		System.out.println("username"+username);
		UserEntity user = userRepository.findByEmail(username);
		System.out.println("users"+user);
		Club club =ClubMapper.mapToClub(clubDto);
		club.setCreatedBy(user);
		return clubRepository.save(club);
    }
    
    @Override
    public ClubDto findClubById(long clubId){
    	Club club = clubRepository.findById(clubId).get();
    	return ClubMapper.mapToClubDto(club);
    	
    }
	@Override
	public void updateClub(ClubDto clubDto) {
		String email = SecurityUtil.getSessionUser();
		UserEntity user = userRepository.findByEmail(email);
		System.out.println("user"+user);
		Club club = ClubMapper.mapToClub(clubDto);
		club.setCreatedBy(user);
		clubRepository.save(club);
	}
	@Override
	public void delete(long clubId) {
		clubRepository.deleteById(clubId);
	}
	
	
	@Override
	public List<ClubDto> searchClubs(String query) {
		List<Club> clubs = clubRepository.searchClubs(query);
		return clubs.stream().map(club-> ClubMapper.mapToClubDto(club)).collect(Collectors.toList());
	}
}
