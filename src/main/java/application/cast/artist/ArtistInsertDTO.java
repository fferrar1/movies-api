package application.cast.artist;

public record ArtistInsertDTO(String name) {
    public ArtistInsertDTO(Artist data) {
        this(data.getName());
    }
}
