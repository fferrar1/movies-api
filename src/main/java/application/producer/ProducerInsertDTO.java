package application.producer;

public record ProducerInsertDTO(String name) {
    public ProducerInsertDTO(Producer data) {
        this(data.getName());
    }
}
