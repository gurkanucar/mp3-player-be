package com.gucardev.mp3playerbe.controller;

import com.gucardev.mp3playerbe.service.MP3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mp3")
@RequiredArgsConstructor
public class MP3Controller {


    private final MP3Service mp3Service;


    @GetMapping(value = "/music/{id}.mp3" , produces = "audio/mp3")
    public Mono<Resource> getVideo(@PathVariable Long id) {
        return mp3Service.getMusicStreaming(id);
    }



}
