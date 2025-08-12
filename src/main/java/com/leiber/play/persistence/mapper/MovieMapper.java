package com.leiber.play.persistence.mapper;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StateMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    @Mapping(source = "estado", target = "state", qualifiedByName = "stringToBoolean")
    MovieDto toDto(MovieEntity movieEntity);

    List<MovieDto> toDto(Iterable<MovieEntity> entities);
}
