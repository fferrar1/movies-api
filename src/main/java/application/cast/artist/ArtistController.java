package application.cast.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @PostMapping
    public ArtistDTO insert(@RequestBody ArtistInsertDTO newArtist) {
        return artistService.insert(newArtist);
    }

    @GetMapping
    public Iterable<ArtistDTO> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public ArtistDTO getOne(@PathVariable long id) {
        return artistService.getOne(id);
    }

    @PutMapping("/{id}")
    public ArtistDTO update(@PathVariable long id, @RequestBody ArtistInsertDTO data) {
        return artistService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        artistService.delete(id);
    }
}
