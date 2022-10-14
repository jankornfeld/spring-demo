package com.example.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Service
@Transactional
@RequiredArgsConstructor
public class InitService {

    private final PhotoService photoService;

    @PostConstruct
    public void initDB() {
        inializePhotos();
    }

    private void inializePhotos() {
        photoService.create("Photo 1", 100, 100);
        photoService.create("Photo 2", 200, 100);
        photoService.create("Photo 3", 100, 200);
    }
}
