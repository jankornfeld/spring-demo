package com.example.demo.persistence.repositories;

import com.example.demo.persistence.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findAllByName(String name);
    List<Photo> findAllByCreationTSBetween(LocalDateTime startTS, LocalDateTime endTS);
}
