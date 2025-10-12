package com.wesovilabs.festify.web.controller;

import com.wesovilabs.festify.dto.request.CreateArtistRequest;
import com.wesovilabs.festify.dto.response.ArtistResumeResponse;
import com.wesovilabs.festify.services.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArtistController {

    final private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public List<ArtistResumeResponse> listArtists(){
        return this.artistService.listArtists();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/artists")
    public ArtistResumeResponse createArtist(@Valid @RequestBody CreateArtistRequest request){
        return this.artistService.createArtist(request);
    }
}
