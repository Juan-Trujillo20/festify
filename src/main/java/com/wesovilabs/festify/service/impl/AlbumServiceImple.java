package com.wesovilabs.festify.service.impl;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResumeResponse;
import com.wesovilabs.festify.mapper.ALbumMapper;
import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;
import com.wesovilabs.festify.persistence.jpa.repository.AlbumJpaRepository;
import com.wesovilabs.festify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumServiceImple implements AlbumService {

    final private AlbumJpaRepository albumJpaRepository;


    @Autowired
    public AlbumServiceImple(AlbumJpaRepository albumJpaRepository) {
        this.albumJpaRepository = albumJpaRepository;
    }


    @Override
    public List<AlbumResumeResponse> listAlbums(String artistId) {
        return List.of();
    }

    @Override
    public AlbumResumeResponse createAlbum(String idArtist, AlbumRequest albumRequest) {

        AlbumEntity album = ALbumMapper.mapAlbumRequestToAlbumEntity(albumRequest);

        AlbumEntity result = this.albumJpaRepository.save(album);

        return  ALbumMapper.mapAlbumToAlbumResume(result);


    }

    @Override
    public AlbumResumeResponse updateAlbum(Long idAlbum, AlbumRequest albumRequest) {
        return null;
    }

    @Override
    public void deleteAlbum(String idArtist, Long idAlbum) {

    }
}
