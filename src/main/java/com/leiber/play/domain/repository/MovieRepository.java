package com.leiber.play.domain.repository;

import com.leiber.play.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
}
