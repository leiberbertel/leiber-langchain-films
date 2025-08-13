package com.leiber.play.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(

        @NotBlank(message = "El título es obligatorio")
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual o igual a la fecha actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "La clasificación no puede ser menor que 0")
        @Max(value = 5, message = "La clasificación no puede ser mayor que 5")
        BigDecimal rating
) {
}
