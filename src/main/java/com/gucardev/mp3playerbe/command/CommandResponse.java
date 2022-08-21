package com.gucardev.mp3playerbe.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandResponse {
    private final CommandNameConstants commandName;
    private final String value;
}
