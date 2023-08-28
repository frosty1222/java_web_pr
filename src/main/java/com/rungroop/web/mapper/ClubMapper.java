package com.rungroop.web.mapper;

import java.util.stream.Collectors;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.models.Event;

public class ClubMapper {
	public static Club mapToClub(ClubDto club) {
		Club clubDto = Club.builder()
				.id(club.getId())
				.title(club.getTitle())
				.photoURL(club.getPhotoURL())
				.content(club.getContent())
				.createdBy(club.getCreatedBy())
				.build();
		return clubDto;
	}
	 public static ClubDto mapToClubDto(Club club) {
	    	ClubDto clubDto = ClubDto.builder()
	    			.id(club.getId())
	    			.title(club.getTitle())
	    			.photoURL(club.getPhotoURL())
	    			.content(club.getContent())
	    			.createdOn(club.getCreatedOn())
	    			.updatedOn(club.getUpdatedOn())
					.createdBy(club.getCreatedBy())
	    			.events(club.getEvents().stream().map((event)->EventMapper.mapToEventDto(event)).collect(Collectors.toList()))
	    			.build();
	       return clubDto;
	  }
}
