package application.genres;

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
@RequestMapping("/genres")
public class GenresController {
    @Autowired
    private GenresService genresService;

    @PostMapping
    public GenresDTO insert(@RequestBody GenresInsertDTO newGenre) {
        return genresService.insert(newGenre);
    }

    @GetMapping
    public Iterable<GenresDTO> getAll() {
        return genresService.getAll();
    }

    @GetMapping("/{id}")
    public GenresDTO getOne(@PathVariable long id) {
        return genresService.getOne(id);
    }

    @PutMapping("/{id}")
    public GenresDTO update(@PathVariable long id, @RequestBody GenresInsertDTO data) {
        return genresService.update(id, data);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        genresService.delete(id);
    }
}
