package com.gucardev.mp3playerbe.command;

import com.corundumstudio.socketio.SocketIOClient;

public interface Command {
    void execute(String room,String value, SocketIOClient senderClient);
}
