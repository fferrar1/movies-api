package application.cast.function;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "functions")
@Getter
@Setter
@NoArgsConstructor
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String description;

    public Function(FunctionDTO data) {
        this.setId(data.id());
        this.setDescription(data.description());
    }

    public Function(FunctionInsertDTO data) {
        this.setDescription(data.description());
    }
}
