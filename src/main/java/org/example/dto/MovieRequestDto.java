package org.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieRequestDto {
    private String name;
    private String releaseDate;
    private String duration;
    private String description;
}
