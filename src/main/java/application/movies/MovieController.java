package application.movies;

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
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MoviesService movService;

    @GetMapping
    public Iterable<MoviesDTO> getAll() {
        return this.movService.getAll();
    }

    @GetMapping("/{id}")
    public MoviesDTO getOne(@PathVariable long id) {
        return this.movService.getOne(id);
    }

    @PostMapping
    public MoviesDTO insert(@RequestBody MoviesInsertDTO newData) {
        return this.movService.insert(newData);
    }

    @PutMapping("/{id}")
    public MoviesDTO update(@PathVariable long id, @RequestBody MoviesInsertDTO data) {
        return this.movService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        movService.delete(id);
    }

}
