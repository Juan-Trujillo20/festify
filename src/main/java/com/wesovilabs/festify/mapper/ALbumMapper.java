package com.wesovilabs.festify.mapper;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResumeResponse;
import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;

public class ALbumMapper {
    public static AlbumResumeResponse mapAlbumToAlbumResume(AlbumEntity albumEntity) {
        return new AlbumResumeResponse(
                albumEntity.getId(),
                albumEntity.getArtistId(),
                albumEntity.getCreatedAt(),
                albumEntity.getDurationSeconds(),
                albumEntity.getReleaseDate(),
                albumEntity.getTitle(),
                albumEntity.getTracksCount(),
                albumEntity.getUpdatedAt()
                );
    }


    public static AlbumEntity mapAlbumRequestToAlbumEntity(AlbumRequest request) {
        return new AlbumEntity(request.artistId(), request.id(), null, request.durationSeconds(), request.releaseDate(), request.title(), request.tracksCount());

    }

}






