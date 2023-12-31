package com.rungroop.web.mapper;

import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Event;

public class EventMapper {
	public static Event mapToEvent(EventDto eventDto) {
		return Event.builder()
        .id(eventDto.getId())
        .name(eventDto.getName())
        .startTime(eventDto.getStartTime())
        .endTime(eventDto.getEndTime())
        .Type(eventDto.getType())
        .photoUrl(eventDto.getPhotoUrl())
        .club(eventDto.getClub()) // Assuming EventDto has a Club field
        .build();
	}
	
	public static EventDto mapToEventDto(Event event) {
		return EventDto.builder()
        .id(event.getId())
        .name(event.getName())
        .startTime(event.getStartTime())
        .endTime(event.getEndTime())
        .Type(event.getType())
        .photoUrl(event.getPhotoUrl())
        .club(event.getClub()) // Assuming EventDto has a Club field
        .build();
	}
}
