package com.leiber.play.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        BigDecimal rating
) {
}
