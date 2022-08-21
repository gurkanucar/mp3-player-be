package com.gucardev.mp3playerbe.model;

import com.corundumstudio.socketio.SocketIOClient;
import com.gucardev.mp3playerbe.command.Command;
import com.gucardev.mp3playerbe.command.CommandNameConstants;
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
    private CommandNameConstants commandName;
    private String value;

}
