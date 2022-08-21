package com.gucardev.mp3playerbe.service;

import com.gucardev.mp3playerbe.model.FileModel;
import com.gucardev.mp3playerbe.repository.FileRepository;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {

    @Value("${server.base_path}")
    String basePath;

    private final FileRepository fileRepository;

    public FileModel save(FileModel file) {
        file.setDuration(getDurationOfFile(file));
        return fileRepository.save(file);
    }

    public FileModel getById(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("file not found!"));
    }

    public List<FileModel> getFiles() {
        return fileRepository.findAll();
    }

    public List<FileModel> getFiles(String search) {
        return fileRepository.findAllByNameContainingIgnoreCase(search);
    }

    public Long getDurationOfFile(FileModel fileModel) {
        try {
            String path = Paths.get(basePath, fileModel.getName() + ".mp3").toString();
            FileSystemResource fileSystemResource = new FileSystemResource(path);


            AudioFileFormat baseFileFormat = null;
            baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(fileSystemResource.getFile());

            Map properties = baseFileFormat.properties();
            Long duration = (Long) properties.get("duration");
            return duration;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
