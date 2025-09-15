package application.cast;

public record CastInsertDTO(long movieId, long artistId, long functionId) {
    public CastInsertDTO(Cast data) {
        this(
            data.getMovie().getId(), 
            data.getArtist().getId(), 
            data.getFunction().getId()
        );
    }
}
