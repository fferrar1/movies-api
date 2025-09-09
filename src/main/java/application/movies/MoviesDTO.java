package application.movies;

import application.genres.GenresDTO;

public record MoviesDTO(long id, String title, GenresDTO genre) {
    public MoviesDTO (Movies data) {
        this(
            data.getId(), 
            data.getTitle(), 
            new GenresDTO(data.getGenre()));
    }
}
