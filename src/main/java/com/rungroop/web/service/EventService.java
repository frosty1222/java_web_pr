package com.rungroop.web.service;

import org.springframework.stereotype.Service;

import com.rungroop.web.dto.EventDto;

@Service
public interface EventService {
  void createEvent(Long clubId, EventDto eventDto);
}
