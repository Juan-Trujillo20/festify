package com.wesovilabs.festify.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateArtistRequest(

        @NotBlank(message = "El nombre del artista es obligatorio")
        @Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
        String name,
        @NotNull(message = "Debes indicar al menos un género")
        @Size(min = 1, message = "Debe tener al menos un género")
        List<String> genres,
        @NotBlank(message = "El país es obligatorio")
        @Pattern(regexp = "^[A-Z]{2}$", message = "El país debe tener el formato de dos letras (por ejemplo, ES, US)")
        String country) {
}
