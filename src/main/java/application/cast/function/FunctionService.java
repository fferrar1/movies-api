package application.cast.function;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FunctionService {
    @Autowired
    private FunctionRepository funcRepo;

    public Iterable<FunctionDTO> getAll() {
        return funcRepo.findAll().stream().map(FunctionDTO::new).toList();
    }

    public FunctionDTO insert(FunctionInsertDTO newFunction) {
        return new FunctionDTO(funcRepo.save(new Function(newFunction)));
    }

    public FunctionDTO getOne(@PathVariable long id) {
        Optional<Function> result = funcRepo.findById(id);

        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Function not found"
            );
        }
        return new FunctionDTO(result.get());
    }

    public FunctionDTO update(long id, FunctionInsertDTO data) {
        Optional<Function> result = funcRepo.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Function not found"
            );
        }

        Function currentFunction = result.get();

        if (data.description() != null) {
            currentFunction.setDescription(data.description());
        }
        return new FunctionDTO(funcRepo.save(currentFunction));
    }

    public void delete(long id) {
        if (!funcRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Function not found"
            );
        }
        funcRepo.deleteById(id);
    }
}
