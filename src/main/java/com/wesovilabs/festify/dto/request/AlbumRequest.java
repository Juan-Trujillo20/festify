package com.wesovilabs.festify.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "Aqui voy a poner los datos del album a crear o a modificar")
public record AlbumRequest(
        String id,
        Long artistId,
        Integer durationSeconds,
        LocalDate releaseDate,
        String title,
        Integer tracksCount

) {


}
