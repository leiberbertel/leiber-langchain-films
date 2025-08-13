package com.leiber.play.domain.dto;

import com.leiber.play.domain.Genre;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        @Null(message = "El id debe ser nulo")
        Long id,

        @NotBlank(message = "El título es obligatorio")
        String title,

        @Min(value = 0, message = "La duración no puede ser menor que 0")
        Integer duration,

        @NotNull(message = "El género es obligatorio")
        Genre genre,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual o igual a la fecha actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "La clasificación no puede ser menor que 0")
        @Max(value = 5, message = "La clasificación no puede ser mayor que 5")
        BigDecimal rating,

        @Null(message = "El estado debe ser nulo")
        Boolean state
) {
}
