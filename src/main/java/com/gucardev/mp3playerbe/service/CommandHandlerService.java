package com.gucardev.mp3playerbe.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.gucardev.mp3playerbe.command.Command;
import com.gucardev.mp3playerbe.command.CommandType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class CommandHandlerService {

    @Autowired
    private Map<String, Command> commandHandlersMap;

    public void executeCommand(CommandType commandType,
                               String room,
                               SocketIOClient senderClient,
                               String commandValue) {
        log.info("Selected command:" + commandType.beanName());
        commandHandlersMap.get(commandType.beanName()).execute(room, commandValue, senderClient);
    }


}
