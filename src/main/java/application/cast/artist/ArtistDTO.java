package application.cast.artist;

public record ArtistDTO(long id, String name) {
    public ArtistDTO(Artist data) {
        this(data.getId(), data.getName());
    }
}
