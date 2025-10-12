package com.wesovilabs.festify.services;

import com.wesovilabs.festify.dto.request.CreateArtistRequest;
import com.wesovilabs.festify.dto.response.ArtistResumeResponse;
import com.wesovilabs.festify.persistence.jpa.entity.ArtistEntity;

import java.util.List;

public interface ArtistService {

    List<ArtistResumeResponse> listArtists();

    ArtistResumeResponse createArtist(CreateArtistRequest request);
}
