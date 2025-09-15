package application.cast;

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
@RequestMapping("/casts")
public class CastController {
    @Autowired
    private CastService service;

    @PostMapping
    public CastDTO insert(@RequestBody CastInsertDTO data) {
        return service.insert(data);
    }

    @PutMapping("/{id}")
    public CastDTO update(@PathVariable long id, @RequestBody CastInsertDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @GetMapping
    public Iterable<CastDTO> getAll() {
        return service.getAll();
    }
}
