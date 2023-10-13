package com.rafaa.Pokemon.service.Impl;

import com.rafaa.Pokemon.dto.ClubDto;
import com.rafaa.Pokemon.model.Club;
import com.rafaa.Pokemon.repository.ClubRepository;
import com.rafaa.Pokemon.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;
    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::mapToClubDto).toList();
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club_org = mapToClub(clubDto);
        clubRepository.save(club_org);
    }

    private Club mapToClub(ClubDto club) {
       Club club_org = Club.builder()
               .id(club.getId())
               .title(club.getTitle())
               .photoUrl(club.getPhotoUrl())
               .content(club.getContent())
               .createdOn(club.getCreatedOn())
               .updatedOn(club.getUpdatedOn())
               .build();
       return club_org;
    }

    private ClubDto mapToClubDto(Club club) {
       ClubDto clubDto = ClubDto.builder()
               .id(club.getId())
               .title(club.getContent())
               .photoUrl(club.getPhotoUrl())
               .content(club.getContent())
               .createdOn(club.getCreatedOn())
               .updatedOn(club.getUpdatedOn())
               .build();
       return clubDto;
    }
}