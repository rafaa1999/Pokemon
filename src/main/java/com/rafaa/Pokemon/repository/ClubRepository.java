package com.rafaa.Pokemon.repository;

import com.rafaa.Pokemon.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club,Long> {
   Optional<Club> findByTitle(String url);
}