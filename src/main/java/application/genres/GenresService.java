package application.genres;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;


@Service
public class GenresService {
    @Autowired
    private GenresRepository genresRepo;

    public Iterable<GenresDTO> getAll() {
        return genresRepo.findAll().stream().map(GenresDTO::new).toList();
    }

    public GenresDTO insert(GenresInsertDTO data) {
        return new GenresDTO(genresRepo.save(new Genres(data)));
    }

    public GenresDTO getOne(@PathVariable long id) {
        Optional<Genres> result = genresRepo.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Genre not found"
            );
        }
        return new GenresDTO(result.get());
    }

    public GenresDTO update(long id, GenresInsertDTO data) {
        Optional<Genres> result = genresRepo.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Genre not found"
            );
        }

        Genres actualGenre = result.get();

        if (data.name() != null) {
            actualGenre.setName(data.name());
        }
        return new GenresDTO(genresRepo.save(actualGenre));
    }

    public void delete(long id) {
        if(!genresRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Genre not found"
            );
        }
        genresRepo.deleteById(id);
    }
}
