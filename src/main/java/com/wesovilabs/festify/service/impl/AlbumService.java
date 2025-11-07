package com.wesovilabs.festify.service.impl;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResumeResponse;

import java.util.List;

public interface AlbumService {

    List<AlbumResumeResponse> listAlbums(String artistId);

    AlbumResumeResponse createAlbum(String idArtist, AlbumRequest albumRequest);

    AlbumResumeResponse updateAlbum(Long idAlbum, AlbumRequest albumRequest);

    void deleteAlbum(String idArtist,Long idAlbum);


}
