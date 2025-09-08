package application.cast.artist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepo;

    public Iterable<ArtistDTO> getAll() {
        return artistRepo.findAll().stream().map(ArtistDTO::new).toList();
    }

    public ArtistDTO insert(ArtistInsertDTO newArtist) {
        return new ArtistDTO(artistRepo.save(new Artist(newArtist)));
    }

    public ArtistDTO getOne(@PathVariable long id) {
        Optional<Artist> result = artistRepo.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Artist not found"
            );
        }
        return new ArtistDTO(result.get());
    }

    public ArtistDTO update(long id, ArtistInsertDTO data) {
        Optional<Artist> result = artistRepo.findById(id);

        if (result.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Artist not found"
            );
        }

        Artist currentArtist = result.get();

        if (data.name() != null) {
            currentArtist.setName(data.name());
        }
        return new ArtistDTO(artistRepo.save(currentArtist));
    }

    public void delete(long id) {
        if(!artistRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Artist not found"
            );
        }
        artistRepo.deleteById(id);
    }
}