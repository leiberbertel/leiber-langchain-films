package com.leiber.play.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record SuggestRequestDto(@NotBlank(message = "Las preferencias son obligatorias") String userPreferences) {
}
