package com.leiber.play.domain.dto;

import com.leiber.play.domain.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        BigDecimal rating,
        Boolean state
) {
}
