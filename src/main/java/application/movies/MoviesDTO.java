package application.movies;

import java.util.List;

import application.genres.GenresDTO;
import application.producer.ProducerDTO;

public record MoviesDTO(long id, String title, GenresDTO genre, List<ProducerDTO> producers) {
    public MoviesDTO (Movies data) {
        this(
            data.getId(), 
            data.getTitle(), 
            new GenresDTO(data.getGenre()),
            data.getProducers().stream().map(ProducerDTO::new).toList());
    }
}
