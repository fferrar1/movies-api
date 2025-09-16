package application.movies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.genres.Genres;
import application.genres.GenresService;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository movieRepo;
    @Autowired
    private GenresService genreService;

    public Iterable<MoviesDTO> getAll() {
        return movieRepo.findAll().stream().map(MoviesDTO::new).toList();
    }

    public MoviesDTO getOne(long id) {
        Optional<Movies> result = movieRepo.findById(id);

        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Movie not found"
            );
        }

        return new MoviesDTO(result.get());
    }

    public MoviesDTO insert(MoviesInsertDTO newMovie) {
        Genres genre = new Genres(genreService.getOne(newMovie.genreId()));

        Movies movies = new Movies();
        movies.setTitle(newMovie.title());
        movies.setGenre(genre);

        return new MoviesDTO(movieRepo.save(movies));
    }

    public MoviesDTO update(long id, MoviesInsertDTO newData) {
        Optional<Movies> result = movieRepo.findById(id);

        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Movie not found"
            );
        }

        Genres genre = new Genres(genreService.getOne(newData.genreId()));

        result.get().setTitle(newData.title());
        result.get().setGenre(genre);

        return new MoviesDTO(movieRepo.save(result.get()));
    }

    public void delete(long id) {
        if(!movieRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Movie not found"
            );
        }
        movieRepo.deleteById(id);
    }
}
