package com.wesovilabs.festify.mapper;

import com.wesovilabs.festify.dto.response.ArtistResumeResponse;
import com.wesovilabs.festify.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    public static ArtistResumeResponse mapArtistToArtistResume(ArtistEntity artistEntity) {
        return new ArtistResumeResponse(
                "ART-"+artistEntity.getId(),
                artistEntity.getName(),
                artistEntity.getCountry(),
                artistEntity.getGenres(),
                artistEntity.getListeners());
    }

}
