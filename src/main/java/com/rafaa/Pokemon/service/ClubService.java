package com.rafaa.Pokemon.service;


import com.rafaa.Pokemon.dto.ClubDto;
import com.rafaa.Pokemon.model.Club;

import java.util.List;

public interface ClubService {
   List<ClubDto> findAllClubs();
   Club saveClub(Club club);
   ClubDto findClubById(long clubId);
   void updateClub(ClubDto club);
}
