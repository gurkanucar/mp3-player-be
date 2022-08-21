package com.gucardev.mp3playerbe.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.gucardev.mp3playerbe.model.FileModel;
import com.gucardev.mp3playerbe.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ServerCommandLineRunner implements CommandLineRunner {

    private final SocketIOServer server;
    private final FileService fileService;


    @Override
    public void run(String... args) throws Exception {
        server.start();

        fileService.save(FileModel.builder().name("ACDC - Back in Black").build());
        fileService.save(FileModel.builder().name("Ceza Yerli Plaka").build());
        fileService.save(FileModel.builder().name("Gazapizm - SagiSolu Kes").build());
        fileService.save(FileModel.builder().name("guzel gunler mazide kalmis").build());
        fileService.save(FileModel.builder().name("Manga - Beni Benimle Birak").build());
        fileService.save(FileModel.builder().name("Ogun Sanlisoy - Saydim").build());
        fileService.save(FileModel.builder().name("Pentagram - Gündüz Gece ").build());
        fileService.save(FileModel.builder().name("Pentagram - Kam").build());
        fileService.save(FileModel.builder().name("Stromae - Alors On Danse (Dubdogz Remix) (Bass Boosted)").build());
        fileService.save(FileModel.builder().name("Yngwie Malmsteen - As Above, So Below (Studio Version)").build());

    }




}
