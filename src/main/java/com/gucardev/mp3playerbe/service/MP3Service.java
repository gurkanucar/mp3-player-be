package com.gucardev.mp3playerbe.service;

import com.gucardev.mp3playerbe.model.FileModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.nio.file.Paths;

@Service
@Slf4j
@RequiredArgsConstructor
public class MP3Service {

    @Value("${server.base_path}")
    String basePath;

    private final FileService fileService;
    private final ResourceLoader resourceLoader;

    public Mono<Resource> getMusicStreaming(Long id) {
        FileModel fileModel = fileService.getById(id);
        // String path = "classpath:" + basePath + "/" + file.getName() + ".mp3";
        String path = Paths.get(basePath, fileModel.getName() + ".mp3").toString();
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        log.info(path);
        return Mono.fromSupplier(() -> fileSystemResource);
    }

}
