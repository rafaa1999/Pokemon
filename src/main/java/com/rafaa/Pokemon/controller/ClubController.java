package com.rafaa.Pokemon.controller;

import com.rafaa.Pokemon.dto.ClubDto;
import com.rafaa.Pokemon.service.Impl.ClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
