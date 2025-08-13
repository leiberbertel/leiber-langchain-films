package com.leiber.play.domain.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long movieId) {
        super("La pelicula con id " + movieId + " no existe");
    }
}
