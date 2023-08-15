package com.rungroop.web.service.impl;

import org.springframework.stereotype.Service;

import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.models.Event;
import com.rungroop.web.repository.ClubRepository;
import com.rungroop.web.repository.EventRepository;
import com.rungroop.web.service.EventService;

@Service
public class EventServiceImpl implements EventService{
    private EventRepository eventRepository;
    private ClubRepository clubRepository;
    
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
    	this.eventRepository = eventRepository;
    	this.clubRepository = clubRepository;
    }
	@Override
	public void createEvent(Long clubId, EventDto eventDto) {
		Club club = clubRepository.findById(clubId).get();
		Event event = mapToEvent(eventDto);
		event.setClub(club);
		eventRepository.save(event);
	}
    
	private Event mapToEvent(EventDto eventDto) {
		return Event.builder()
        .id(eventDto.getId())
        .name(eventDto.getName())
        .startTime(eventDto.getStartTime())
        .endTime(eventDto.getEndTime())
        .type(eventDto.getType())
        .photoUrl(eventDto.getPhotoUrl())
        .club(eventDto.getClub()) // Assuming EventDto has a Club field
        .build();
	}
}
