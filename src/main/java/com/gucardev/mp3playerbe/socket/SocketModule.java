package com.gucardev.mp3playerbe.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.gucardev.mp3playerbe.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SocketModule {


    private final SocketIOServer server;
    private final CommandHandlerService commandHandlerService;

    public SocketModule(SocketIOServer server, SocketService socketService, CommandHandlerService commandHandlerService) {
        this.server = server;
        this.commandHandlerService = commandHandlerService;
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener("commands", Message.class, onChatReceived());

    }


    private DataListener<Message> onChatReceived() {
        return (senderClient, data, ackSender) -> {
           // log.info(data.toString());
            commandHandlerService.executeCommand(data.getCommandName(),
                    data.getRoom(),
                    senderClient,
                    data.getValue());
            // data.get().execute(data.getRoom(), data.getValue(), senderClient);
        };
    }


    private ConnectListener onConnected() {
        return (client) -> {
            String room = client.getHandshakeData().getSingleUrlParam("room");
            client.joinRoom(room);
            log.info("Socket ID[{}] - room[{}]  Connected to chat module through", client.getSessionId().toString(), room);
        };

    }

    private DisconnectListener onDisconnected() {
        return client -> {
            log.info("Client[{}] - Disconnected from chat module.", client.getSessionId().toString());
        };
    }


}
