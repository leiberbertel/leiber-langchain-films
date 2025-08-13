package com.leiber.play.web.controller;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.domain.dto.SuggestRequestDto;
import com.leiber.play.domain.dto.UpdateMovieDto;
import com.leiber.play.domain.service.LeiberPlayAiService;
import com.leiber.play.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Peliculas", description = "Operaciones relacionadas con las películas de LeiberFilms AI")
public class MovieController {

    private final String platform;
    private final MovieService movieService;
    private final LeiberPlayAiService leiberPlayAiService;

    public MovieController(@Value("${spring.application.name}") String platform,
                           MovieService movieService,
                           LeiberPlayAiService leiberPlayAiService) {
        this.platform = platform;
        this.movieService = movieService;
        this.leiberPlayAiService = leiberPlayAiService;
    }

    @GetMapping()
    @Operation(
            summary = "Obtiene todas las peliculas del sistema",
            description = "Retorna todas las peliculas del sistema",
            responses = {
                    @ApiResponse(responseCode = "200")
            }
    )
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity
                .ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtiene una película por su identificador",
            description = "Retorna la película que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película encontrada"),
                    @ApiResponse(responseCode = "404", description = "Película no encontrada", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(
            @Parameter(description = "Identificador de la película a obtener",
                    example = "9")
            @PathVariable Long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if (movieDto == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping()
    @Operation(
            summary = "Guarda una nueva película",
            description = "Guarda una nueva película si cumple las condiciones del esquema Movie",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película registrada"),
                    @ApiResponse(responseCode = "400", description = "La película ya existe", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> save(@RequestBody @Valid MovieDto movie) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.movieService.save(movie));
    }

    @PostMapping("/suggest")
    @Operation(
            summary = "Retorna 3 sugerencias de peliculas",
            description = "Sugiere 3 peliculas registradas en el sistema al usuario de acuerdo a las preferencias enviadas",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Las preferencias son obligatorias", content = @Content)
            }
    )
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody @Valid SuggestRequestDto suggestRequestDto) {
        return ResponseEntity
                .ok(this.leiberPlayAiService.
                        generateMoviesSuggestion(platform, suggestRequestDto.userPreferences()));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza una película por su id",
            description = "Actualiza los campos de title, releaseDate y rating de un película",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película actualizada"),
                    @ApiResponse(responseCode = "400", description = "La película no existe", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto movie) {
        return ResponseEntity
                .ok(this.movieService.update(id, movie));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Elimina una película por su id",
            description = "Si el borrado es exitoso retorna la entidad borrada",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película eliminada"),
                    @ApiResponse(responseCode = "400", description = "La película no existe", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> delete(@PathVariable Long id) {
        return ResponseEntity
                .ok(this.movieService.delete(id));
    }
}
