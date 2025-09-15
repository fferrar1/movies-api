package application.producer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository repository;

    public Iterable<ProducerDTO> getAll() {
        return repository.findAll().stream().map(ProducerDTO::new).toList();
    }

    public ProducerDTO getOne(long id) {
        Optional<Producer> result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Artista não encontrado"
            );
        }

        return new ProducerDTO(result.get());
    }

    public ProducerDTO insert(ProducerInsertDTO newProducer) {
        return new ProducerDTO(repository.save(new Producer(newProducer)));
    }

    public ProducerDTO update(long id, ProducerInsertDTO newProducer) {
        Optional<Producer> result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Producer not found"
            );
        }

        Producer producer = result.get();
        producer.setName(newProducer.name());

        return new ProducerDTO(repository.save(producer));
    }

    public void delete(long id) {
        Optional<Producer> result = repository.findById(id);

        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Producer not found"
            );
        }

        repository.deleteById(id);
    }
}
