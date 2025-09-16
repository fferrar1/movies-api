package application.movies;

import java.util.List;

public record MoviesInsertDTO(String title, long genreId, List<Long> producersIds) {
    
}
