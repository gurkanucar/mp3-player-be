package com.gucardev.mp3playerbe.command;

import com.corundumstudio.socketio.SocketIOClient;
import com.gucardev.mp3playerbe.socket.SocketService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeekCommand implements Command {

    private final SocketService service;

    @Override
    public void execute(String room,String value, SocketIOClient senderClient) {
        service.sendCommand(room, senderClient, CommandNameConstants.SEEK_TO, value);
    }
}
