package com.gucardev.mp3playerbe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FileModel extends BaseEntity {

    private String name;
    private String location;
    private Long duration;


}
