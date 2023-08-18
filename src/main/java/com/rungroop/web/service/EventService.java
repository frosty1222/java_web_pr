package com.rungroop.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rungroop.web.dto.EventDto;

@Service
public interface EventService {
  void createEvent(Long clubId, EventDto eventDto);
  List<EventDto> findAllEvents();

  EventDto findEventById(Long eventId);

  void updateEvent(EventDto eventDto);

    void delete(Long eventId);
}
