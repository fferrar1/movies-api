package application.producer;

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
@RequestMapping("/producers")
public class ProducerController {
    @Autowired
    private ProducerService service;

    @GetMapping
    public Iterable<ProducerDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProducerDTO getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @PostMapping
    public ProducerDTO insert(@RequestBody ProducerInsertDTO newProducer) {
        return service.insert(newProducer);
    }

    @PutMapping("/{id}")
    public ProducerDTO update(@PathVariable long id, @RequestBody ProducerInsertDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
