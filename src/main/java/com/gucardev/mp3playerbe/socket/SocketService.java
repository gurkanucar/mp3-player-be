package com.gucardev.mp3playerbe.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.gucardev.mp3playerbe.command.Command;
import com.gucardev.mp3playerbe.command.CommandType;
import com.gucardev.mp3playerbe.command.CommandResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class SocketService {


    public void sendCommand(String room, SocketIOClient senderClient, CommandType commandName, String commandValue) {
        log.info("Command sent: " + commandName.toString());
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("get_command",
                        new CommandResponse(commandName, commandValue));
            }
        }
    }


}
