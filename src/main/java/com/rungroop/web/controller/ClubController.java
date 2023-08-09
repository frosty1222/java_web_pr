package com.rungroop.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.service.ClubService;

import jakarta.validation.Valid;


@Controller
public class ClubController {
  private final ClubService clubService;
  
 
  @Autowired
  public ClubController(ClubService clubService) {
	this.clubService = clubService;
  }



  @GetMapping("/clubs")
  public String listClubs(Model model) {
	  List<ClubDto> clubs  = clubService.findAllClubs();
	  model.addAttribute("clubs",clubs);
	  return "club";
  }
  
  @GetMapping("/clubs/new")
  public String CreateCubCubForm(Model model) {
	  model.addAttribute("club",new Club());
	  return "create";
  }
  
  @PostMapping("/clubs/new")
  public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,BindingResult result, Model model) {
	  if(result.hasErrors()) {
		  model.addAttribute("club",clubDto);
		  return "create";
	  }
	  clubService.saveClub(clubDto);
	  return "redirect:/clubs";
  }
  @GetMapping("/clubs/{clubId}/edit")
  public String editClubForm(@PathVariable("clubId") long clubId,Model model) {
	  ClubDto club = clubService.findClubById(clubId);
	  model.addAttribute("club",club);
	  return "club-edit";
  }
  
  @PostMapping("/clubs/{clubId}/edit")
  public String updateClub(@PathVariable("clubId") long clubId,@Valid @ModelAttribute("club") ClubDto club,BindingResult result) {
	  if(result.hasErrors()) {
		  return "club-edit";
	  }
	  club.setId(clubId);
	  clubService.updateClub(club);
	  return "redirect:/clubs";
   }
  
  @GetMapping("/clubs/{clubId}")
  public String clubDetail(@PathVariable("clubId") long clubId,Model model) {
	  ClubDto clubDto = clubService.findClubById(clubId);
	  model.addAttribute("club",clubDto);
	  return "club-detail";
  }
  
  @GetMapping("/clubs/{clubId}/delete")
  public String deleteClub(@PathVariable("clubId") long clubId) {
	  clubService.delete(clubId);
	  return "redirect:/clubs";
  }
  
  @GetMapping("/clubs/search")
  public String searchClub(@RequestParam(value="query") String query, Model model) {
	  List<ClubDto> clubs = clubService.searchClubs(query);
	  model.addAttribute("clubs",clubs);
	  return "club-list";
  }
}
