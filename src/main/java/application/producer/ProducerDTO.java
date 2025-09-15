package application.producer;

public record ProducerDTO(Long id, String name) {
    public ProducerDTO(Producer producer) {
        this(producer.getId(), producer.getName());
    }
}
