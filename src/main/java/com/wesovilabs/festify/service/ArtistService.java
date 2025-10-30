package com.wesovilabs.festify.service;

import com.wesovilabs.festify.dto.request.ArtistRequest;
import com.wesovilabs.festify.dto.response.ArtistDetailResponse;
import com.wesovilabs.festify.dto.response.ArtistResumeResponse;

import java.util.List;

public interface ArtistService {

    List<ArtistResumeResponse> listArtists();

    ArtistResumeResponse createArtist(ArtistRequest request);

    ArtistDetailResponse updateArtist(String id, ArtistRequest request);

    ArtistDetailResponse getArtistById(String id);

    void deleteArtist(String id);
}
