package com.rungroop.web.controller;

import java.util.List;

import com.rungroop.web.dto.ClubDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Event;
import com.rungroop.web.service.EventService;

import jakarta.validation.Valid;

@Controller
public class EventController {
   private EventService eventService;
     
   public EventController(EventService eventService) {
		this.eventService = eventService;
   }
   
  @GetMapping("/events/{clubId}/new")
  public String createEventForm(@PathVariable("clubId") Long clubId, Model model) {
	  Event event = new Event();
	  model.addAttribute("clubId",clubId);
	  model.addAttribute("event",event);
	  return "events";
  }
  
  @PostMapping("/events/{clubId}")
  public String createEvent(@PathVariable("clubId") Long clubId,@Valid @ModelAttribute("event") EventDto eventDto, Model model,BindingResult result) {
	  if(result.hasErrors()) {
		  return "events";
	  }
      eventService.createEvent(clubId, eventDto);
      return "redirect:/clubs/" + clubId;
  }
  
  @GetMapping("/events")
  public String eventList(Model model) {
	  List<EventDto> events = eventService.findAllEvents();
	  model.addAttribute("events",events);
	  return "event-list";
  }

  @GetMapping("/events-detail/{eventId}")
    public String eventDetail(@PathVariable("eventId") Long eventId,  Model model){
       EventDto eventDto = eventService.findEventById(eventId);
       model.addAttribute("events",eventDto);
       return "events-detail";
    }
  @GetMapping("/events/{eventId}/edit")
  public String eventEdit(@PathVariable("eventId") Long eventId,Model model){
       EventDto eventDto = eventService.findEventById(eventId);
       model.addAttribute("event",eventDto);
       return "event-edit";

  }
  @PostMapping("/events/{eventId}/edit")
  public String eventEdit(@PathVariable("eventId") Long eventId,@Valid  @ModelAttribute("club") EventDto eventDto, Model model, BindingResult result){
    EventDto event =  eventService.findEventById(eventId);
     if(result.hasErrors()){
         model.addAttribute("event",eventDto);
         return "event-edit";
     }
      eventDto.setId(eventId);
      eventDto.setClub(event.getClub());
      eventService.updateEvent(eventDto);
      return "redirect:/events";
  }
  @GetMapping("/events/{eventId}/delete")
  public String deleteSingleEvent(@PathVariable("eventId") Long eventId){
       eventService.delete(eventId);
       return "redirect:/events";
  }
}
