package com.gucardev.mp3playerbe.controller;

import com.gucardev.mp3playerbe.model.FileModel;
import com.gucardev.mp3playerbe.service.FileService;
import com.gucardev.mp3playerbe.service.MP3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/mp3")
@RequiredArgsConstructor
public class MP3Controller {


    private final MP3Service mp3Service;
    private final FileService fileService;

    @CrossOrigin
    @GetMapping(value = "/music")
    public ResponseEntity<List<FileModel>> getMusicList() {
        return ResponseEntity.ok(fileService.getFiles());
    }

    @CrossOrigin
    @GetMapping(value = "/music/{id}")
    public ResponseEntity<FileModel> getMusicList(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.getById(id));
    }


    @CrossOrigin
    @GetMapping(value = "/music/{id}.mp3", produces = "audio/mp3")
    public Mono<Resource> getMusic(@PathVariable Long id) {
        return mp3Service.getMusicStreaming(id);
    }


}
