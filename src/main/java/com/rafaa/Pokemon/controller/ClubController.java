package com.rafaa.Pokemon.controller;

import com.rafaa.Pokemon.dto.ClubDto;
import com.rafaa.Pokemon.model.Club;
import com.rafaa.Pokemon.service.ClubService;
import com.rafaa.Pokemon.service.Impl.ClubServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
   private ClubService clubService;
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
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,
                           BindingResult result,
                           Model model){
       if(result.hasErrors()){
           model.addAttribute("club", clubDto);
           return "clubs-create";
       }
       clubService.saveClub(clubDto);
       return "redirect:/clubs";
    }
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model){
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }
    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") long clubId,
                             @Valid @ModelAttribute("club") ClubDto club,
                             BindingResult result){
        if(result.hasErrors()){
            return "clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
}
