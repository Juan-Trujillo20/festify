package com.wesovilabs.festify.mapper;

import com.wesovilabs.festify.dto.request.ArtistRequest;
import com.wesovilabs.festify.dto.response.ArtistDetailResponse;
import com.wesovilabs.festify.dto.response.ArtistResumeResponse;
import com.wesovilabs.festify.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    private static String toPubId(Long artistId) {
        return "ART-"+artistId;
    }
    public static ArtistResumeResponse mapArtistToArtistResume(ArtistEntity artistEntity) {
        return new ArtistResumeResponse(
                toPubId(artistEntity.getId()),
                artistEntity.getName(),
                artistEntity.getCountry(),
                artistEntity.getGenres(),
                artistEntity.getListeners());
    }

    public static ArtistEntity mapArtistRequestToArtistEntity(ArtistRequest request) {
        return new ArtistEntity(null, request.name(),request.genres(),request.country(),request.listeners(),request.status(),request.biography());
    }

    public static ArtistDetailResponse mapArtistToArtistDetail(ArtistEntity artistEntity) {
        return new ArtistDetailResponse(
                toPubId(artistEntity.getId()),
                artistEntity.getName(),
                artistEntity.getGenres(),
                artistEntity.getCountry(),
                artistEntity.getListeners(),
                artistEntity.getStatus(),
                artistEntity.getBiography());
    }
}
