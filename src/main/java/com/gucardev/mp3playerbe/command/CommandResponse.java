package com.gucardev.mp3playerbe.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandResponse {
    private final CommandType commandName;
    private final String value;
}
