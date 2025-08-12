package com.leiber.play.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        String title,
        Integer duration,
        String genre,
        LocalDate releaseDate,
        BigDecimal rating,
        String state
) {
}
