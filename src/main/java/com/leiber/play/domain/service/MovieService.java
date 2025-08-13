package com.leiber.play.domain.service;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.domain.dto.UpdateMovieDto;
import com.leiber.play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las películas que existan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(Long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto save(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.update(id, updateMovieDto);
    }

    public MovieDto delete(Long id) {
        return this.movieRepository.delete(id);
    }
}
