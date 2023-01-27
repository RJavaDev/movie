package org.example.dto;

import lombok.Data;

@Data
public class MovieRequestDto {

    private String name;
    private String url;
    private String releaseDate;
    private String duration;
    private String description;
}
