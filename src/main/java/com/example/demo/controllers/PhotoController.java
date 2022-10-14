package com.example.demo.controllers;

import com.example.demo.persistence.entities.Orientation;
import com.example.demo.persistence.entities.Photo;
import com.example.demo.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/")
    public HttpEntity<List<PhotoDto>> getAll() {
        return Optional.of(photoService.findAllPhotos()
                        .stream()
                        .map(PhotoDto::new)
                        .toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    public static record PhotoDto(Long id, String name, Integer width, Integer Height, Orientation orientation) {
        public PhotoDto(Photo photo) {
            this(photo.getId(), photo.getName(), photo.getWidth(), photo.getHeight(), photo.getOrientation());
        }
    }
}
