package com.gucardev.mp3playerbe.model;

import com.gucardev.mp3playerbe.command.CommandType;
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
    private CommandType commandName;
    private String value;

}
