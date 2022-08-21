package com.gucardev.mp3playerbe.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.gucardev.mp3playerbe.command.CommandNameConstants;
import com.gucardev.mp3playerbe.command.CommandResponse;
import org.springframework.stereotype.Service;

@Service
public class SocketService {

    private void sendCommand(String room, SocketIOClient senderClient, CommandNameConstants commandName, String commandValue) {
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("get_command",
                        new CommandResponse(commandName, commandValue));
            }
        }
    }


}
