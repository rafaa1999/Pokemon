package com.rafaa.Pokemon.controller;

import com.rafaa.Pokemon.dto.ClubDto;
import com.rafaa.Pokemon.model.Club;
import com.rafaa.Pokemon.service.Impl.ClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
   private ClubServiceImpl clubService;
   @Autowired
   public ClubController(ClubServiceImpl clubService) {
       this.clubService = clubService;
   }
    @GetMapping("/clubs")
    public String listClubs(Model model){
       List<ClubDto> clubDtos = clubService.findAllClubs();
       model.addAttribute("clubs", clubDtos);
       return "club-list";
    }
    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }
    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club ){
       clubService.saveClub(club);
       return "redirect:/clubs";
    }
}
