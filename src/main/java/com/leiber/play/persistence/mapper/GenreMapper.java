package com.leiber.play.persistence.mapper;

import com.leiber.play.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genero) {
        if (genero == null) {
            return null;
        }

        return switch (genero.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "TERROR" -> Genre.HORROR;
            case "ANIMADA" -> Genre.ANIMATED;
            case "DRAMA" -> Genre.DRAMA;
            case "CIENCIA_FICCION" -> Genre.SCI_FE;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        if (genre == null) {
            return null;
        }

        return switch (genre) {
            case Genre.ACTION -> "ACCION";
            case Genre.DRAMA -> "DRAMA";
            case Genre.ANIMATED -> "ANIMADA";
            case Genre.SCI_FE -> "CIENCIA_FICCION";
            case Genre.HORROR -> "TERROR";
        };
    }

    private GenreMapper(){}
}
