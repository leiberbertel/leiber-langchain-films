package com.leiber.play.persistence;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.domain.dto.UpdateMovieDto;
import com.leiber.play.domain.repository.MovieRepository;
import com.leiber.play.persistence.crud.CrudMovieEntity;
import com.leiber.play.persistence.entity.MovieEntity;
import com.leiber.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) {
            return null;
        }

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public Optional<MovieDto> delete(Long id) {
        Optional<MovieEntity> movieEntity = this.crudMovieEntity.findById(id);

        movieEntity.ifPresent(this.crudMovieEntity::delete);
        return Optional.ofNullable(this.movieMapper.toDto(movieEntity.orElse(null)));
    }
}
