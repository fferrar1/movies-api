package application.cast;

public record CastInsertDTO(long MovieId, long ArtistId, long FunctionId) {
    public CastInsertDTO(Cast data) {
        this(
            data.getMovie().getId(), 
            data.getArtist().getId(), 
            data.getFunction().getId()
        );
    }
}
