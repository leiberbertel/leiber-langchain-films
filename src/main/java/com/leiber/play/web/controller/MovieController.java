package com.leiber.play.web.controller;

import com.leiber.play.domain.dto.MovieDto;
import com.leiber.play.domain.dto.SuggestRequestDto;
import com.leiber.play.domain.dto.UpdateMovieDto;
import com.leiber.play.domain.service.LeiberPlayAiService;
import com.leiber.play.domain.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
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
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity
                .ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if (movieDto == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping()
    public ResponseEntity<MovieDto> save(@RequestBody @Valid MovieDto movie) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.movieService.save(movie));
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody @Valid SuggestRequestDto suggestRequestDto) {
        return ResponseEntity
                .ok(this.leiberPlayAiService.
                        generateMoviesSuggestion(platform,suggestRequestDto.userPreferences()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto movie) {
        return ResponseEntity
                .ok(this.movieService.update(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable Long id) {
        return ResponseEntity
                .ok(this.movieService.delete(id));
    }
}
