package com.leiber.play.persistence;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.domain.dto.UpdateMovieDto;
import com.leiber.play.domain.exception.MovieAlreadyExistsException;
import com.leiber.play.domain.exception.MovieNotFoundException;
import com.leiber.play.domain.repository.MovieRepository;
import com.leiber.play.domain.util.Constant;
import com.leiber.play.persistence.crud.CrudMovieEntity;
import com.leiber.play.persistence.entity.MovieEntity;
import com.leiber.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        }

        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setEstado(Constant.State.ACTIVE);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) {
            throw new MovieNotFoundException(id);
        }

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto delete(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) {
            throw new MovieNotFoundException(id);
        }

        this.crudMovieEntity.deleteById(id);
        return this.movieMapper.toDto(movieEntity);
    }
}
