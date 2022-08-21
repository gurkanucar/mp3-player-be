package com.gucardev.mp3playerbe.command;

import com.corundumstudio.socketio.SocketIOClient;
import com.gucardev.mp3playerbe.socket.SocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service(CommandType.VOLUME_BEAN_NAME)
public class VolumeCommand implements Command {

    private final SocketService service;

    @Override
    public void execute(String room, String value, SocketIOClient senderClient) {
        service.sendCommand(room, senderClient, CommandType.VOLUME, value);
    }
}
