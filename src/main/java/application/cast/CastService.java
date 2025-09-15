package application.cast;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.movies.Movies;
import application.movies.MoviesRepository;
import application.cast.artist.Artist;
import application.cast.artist.ArtistRepository;
import application.cast.function.Function;
import application.cast.function.FunctionRepository;

@Service
public class CastService {
    @Autowired
    private CastRepository castRepo;
    @Autowired
    private MoviesRepository movieRepo;
    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private FunctionRepository functionRepo;

    public Iterable<CastDTO> getAll() {
        return castRepo.findAll().stream().map(CastDTO::new).toList();
    }

    public CastDTO insert(CastInsertDTO data) {
        Optional<Movies> movieResult = movieRepo.findById(data.movieId());
        Optional<Artist> artistResult = artistRepo.findById(data.artistId());
        Optional<Function> functionResult = functionRepo.findById(data.functionId());

        String errorMessage = "Data not found for: ";
        boolean isError = false;

        if(movieResult.isEmpty()) {
            if(isError)
                errorMessage += ", ";
            errorMessage += "Movie";
            isError = true;
        }
        if(artistResult.isEmpty()) {
            if(isError)
                errorMessage += ", ";
            errorMessage += "Artist";
            isError = true;
        }
        if(functionResult.isEmpty()) {
            if(isError)
                errorMessage += ", ";
            errorMessage += "Function";
            isError = true;
        }
        if(isError) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, errorMessage
            );
        }

        Cast newCast = new Cast();
        newCast.setMovie(movieResult.get());
        newCast.setArtist(artistResult.get());
        newCast.setFunction(functionResult.get());

        return new CastDTO(castRepo.save(newCast));
    }

    public CastDTO update(long id, CastInsertDTO data) {
        Optional<Cast> castResult = castRepo.findById(id);
        if (castResult.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cast not found"
            );
        }
        Optional<Movies> movieResult = movieRepo.findById(data.movieId());
        Optional<Artist> artistResult = artistRepo.findById(data.artistId());
        Optional<Function> functionResult = functionRepo.findById(data.functionId());

        String mensagem = "Cast not found for: ";
        boolean isError = false;

        if(movieResult.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Movies";
            isError = true;
        }
        if(artistResult.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Artist";
            isError = true;
        }
        if(artistResult.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Função";
            isError = true;
        }
        if(isError) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, mensagem
            );
        }

        castResult.get().setMovie(movieResult.get());
        castResult.get().setArtist(artistResult.get());
        castResult.get().setFunction(functionResult.get());

        return new CastDTO(castRepo.save(castResult.get()));
    }

    public void delete(long id) {
        if(!castRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cast not found"
            );
        }

        castRepo.deleteById(id);
    }

    
}
