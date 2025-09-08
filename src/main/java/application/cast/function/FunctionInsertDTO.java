package application.cast.function;

public record FunctionInsertDTO(String description) {
    public FunctionInsertDTO(Function data) {
        this(data.getDescription());
    }
    
}
