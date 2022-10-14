package com.example.demo.services;

import com.example.demo.controllers.PhotoController;
import com.example.demo.persistence.entities.Orientation;
import com.example.demo.persistence.entities.Photo;
import com.example.demo.persistence.repositories.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Validated
@Transactional
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final DateTimeFactory dateTimeFactory;

    public Photo create(@NotEmpty String name, @Positive Integer width, @Positive Integer height) {
        Photo photo = Photo.builder()
                .name(name)
                .width(width)
                .height(height)
                .creationTS(this.dateTimeFactory.now())
                .orientation(determinOrentation(width, height))
                .build();
        return this.photoRepository.save(photo);
    }

    private Orientation determinOrentation(Integer width, Integer height) {
        if (width.equals(height)) {
            return Orientation.SQUARE;
        } else if (width < height) {
            return Orientation.PORTRAIT;
        } else {
            return Orientation.LANDSCAPE;
        }
    }

    @Cacheable("allPhotos")
    public List<Photo> findAllPhotos() {
        return photoRepository.findAll();
    }
}
