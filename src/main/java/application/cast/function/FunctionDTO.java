package application.cast.function;

public record FunctionDTO(long id, String description) {
    public FunctionDTO(Function data) {
        this(data.getId(), data.getDescription());
    }
    
}
