package com.leiber.play.domain.repository;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();

    MovieDto getById(Long id);

    MovieDto save(MovieDto movieDto);

    MovieDto update(Long id, UpdateMovieDto movieDto);

    MovieDto delete(Long id);
}
