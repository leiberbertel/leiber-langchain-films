package com.leiber.play.domain.repository;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.domain.dto.UpdateMovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<MovieDto> getAll();

    MovieDto getById(Long id);

    MovieDto save(MovieDto movieDto);

    MovieDto update(Long id, UpdateMovieDto movieDto);
    Optional<MovieDto> delete(Long id);
}
