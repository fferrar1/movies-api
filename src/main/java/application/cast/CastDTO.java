package application.cast;

import application.cast.artist.ArtistDTO;
import application.cast.function.FunctionDTO;
import application.movies.MoviesDTO;

public record CastDTO(long id, MoviesDTO movie, ArtistDTO artist, FunctionDTO function) {
    public CastDTO(Cast data) {
        this(data.getId(),
        new MoviesDTO(data.getMovie()),
        new ArtistDTO(data.getArtist()),
        new FunctionDTO(data.getFunction()));
    }
}
