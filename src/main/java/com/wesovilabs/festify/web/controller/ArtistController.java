package com.wesovilabs.festify.web.controller;

import com.wesovilabs.festify.dto.request.ArtistRequest;
import com.wesovilabs.festify.dto.response.ArtistDetailResponse;
import com.wesovilabs.festify.dto.response.ArtistResumeResponse;
import com.wesovilabs.festify.service.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Artistas", description = "Gestión de artistas")
@CrossOrigin(origins = "*")
@RestController
public class ArtistController {

    final private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Operation(
            summary = "Lista de artistas",
            description = "Devuelve la lista de los artistas"
    )
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ArtistResumeResponse.class))
            )
    )
    @GetMapping("/artists")
    @ResponseStatus(HttpStatus.OK)
    public List<ArtistResumeResponse> listArtists(){
        return this.artistService.listArtists();
    }


    @Operation(
            summary = "Devuelve un artista",
            description = "Devuelve el detalle de un artista"
    )
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = ArtistResumeResponse.class)))
    @ApiResponse(responseCode = "404", description = "Artista no encontrado con el Id proporcionado",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @GetMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistDetailResponse getArtist(@PathVariable String id){
        return this.artistService.getArtistById(id);
    }
    @Operation(summary = "Elimina un artista")
    @ApiResponse(responseCode = "204", description = "Eliminado")
    @ApiResponse(responseCode = "404", description = "Artista no encontrado con el Id proporcionado",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @DeleteMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable String id){
        this.artistService.deleteArtist(id);
    }
    @Operation(summary = "Crea un artista")
    @ApiResponse(responseCode = "201", description = "Creado",
            content = @Content(schema = @Schema(implementation = ArtistResumeResponse.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de datos",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @PostMapping("/artists")
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistResumeResponse createArtist(@Valid @RequestBody ArtistRequest request){
        return this.artistService.createArtist(request);
    }
    @Operation(summary = "Actualiza un artista")
    @ApiResponse(responseCode = "200", description = "Actualizado",
            content = @Content(schema = @Schema(implementation = ArtistResumeResponse.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de datos",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @ApiResponse(responseCode = "404", description = "Artista no encontrado con el Id proporcionado",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @PutMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistDetailResponse updateArtist(@PathVariable String id, @Valid @RequestBody ArtistRequest request){
        return this.artistService.updateArtist(id,request);
    }
}
