package com.gucardev.mp3playerbe.model;

import com.corundumstudio.socketio.SocketIOClient;
import com.gucardev.mp3playerbe.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String room;
    private Command command;
    private String value;

}
