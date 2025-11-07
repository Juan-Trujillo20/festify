package com.wesovilabs.festify.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlbumDetailResponse(
        Long id,
        Long artistId,
        LocalDateTime createdAt,
        Integer durationSeconds,
        LocalDate releaseDate,
        String title,
        Integer tracksCount,
        LocalDateTime updatedAt
) {
}
