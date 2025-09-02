package application.genres;

public record GenresInsertDTO(String name) {
    public GenresInsertDTO(Genres data) {
        this(data.getName());
    }
}
