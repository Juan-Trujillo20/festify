package com.wesovilabs.festify.services.impl;

import com.wesovilabs.festify.dto.request.CreateArtistRequest;
import com.wesovilabs.festify.dto.response.ArtistResumeResponse;
import com.wesovilabs.festify.mapper.ArtistMapper;
import com.wesovilabs.festify.persistence.jpa.entity.ArtistEntity;
import com.wesovilabs.festify.persistence.jpa.repository.ArtistJpaRepository;
import com.wesovilabs.festify.services.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    final private ArtistJpaRepository artistJpaRepository;

    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistJpaRepository) {
        this.artistJpaRepository = artistJpaRepository;
    }

    @Override
    public List<ArtistResumeResponse> listArtists() {
        List<ArtistEntity> artists =  this.artistJpaRepository.findAll();
        return artists.stream().map(ArtistMapper::mapArtistToArtistResume).toList();
    }

    @Override
    public ArtistResumeResponse createArtist(CreateArtistRequest request) {
        ArtistEntity artist = new ArtistEntity(request.name(),request.genres(),request.country());
        logger.info("Creating artist with name {} and country {}", artist.getName(), artist.getCountry());
        ArtistEntity result = this.artistJpaRepository.save(artist);
        return ArtistMapper.mapArtistToArtistResume(result);
    }
}
