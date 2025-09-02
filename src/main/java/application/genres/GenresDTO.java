package application.genres;

public record GenresDTO(long id, String name) {
    public GenresDTO(Genres data) {
        this(data.getId(), data.getName());
    }
}
