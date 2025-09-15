package application.cast.function;

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
@RequestMapping("/functions")
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @PostMapping
    public FunctionDTO insert(@RequestBody FunctionInsertDTO newFunction) {
        return functionService.insert(newFunction);
    }

    @GetMapping
    public Iterable<FunctionDTO> getAll() {
        return functionService.getAll();
    }

    @GetMapping("/{id}")
    public FunctionDTO getOne(@PathVariable long id) {
        return functionService.getOne(id);
    }

    @PutMapping("/{id}")
    public FunctionDTO update(@PathVariable long id, @RequestBody FunctionInsertDTO data) {
        return functionService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        functionService.delete(id);
    }
}
