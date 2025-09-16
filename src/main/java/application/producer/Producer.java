package application.producer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    public Producer(ProducerDTO data) {
        this.setId(data.id());
        this.setName(data.name());
    }

    public Producer(ProducerInsertDTO data) {
        this.setName(data.name());
    }

    public Producer(long id) {
        this.setId(id);
    }
}
