package com.wesovilabs.festify.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.util.List;

@Schema(description = "Datos de artista a crear o modificar")
public record ArtistRequest(

        @NotBlank(message = "El nombre del artista es obligatorio")
        @Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
        String name,

        @NotNull(message = "Debes indicar al menos un género")
        @Size(min = 1, message = "Debe tener al menos un género")
        List<String> genres,

        @NotBlank(message = "El país es obligatorio")
        @Pattern(regexp = "^[A-Z]{2}$", message = "El país debe tener el formato de dos letras (por ejemplo, ES, US)")
        String country,


        @PositiveOrZero(message = "El número de oyentes no puede ser inferior a 0")
        Integer listeners,


        @Pattern(regexp = "^Activo|Borrador$", message = "El estado del artista debe ser Activo o Borrador")
        String status,

        @Max(value = 2000, message = "No se permiten más de 2000 caracteres")
        String biography
) {
}
