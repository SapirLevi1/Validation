package il.ac.hit.validation;
import java.util.Optional;
/**
 * Interface representing the outcome of a validation process.
 * Provides compliance details for system entities.
 */
public interface ValidationResult {
    /**
     * Checks if the validation checked out successfully.
     * @return true if valid, false otherwise.
     */
    boolean isValid();
    /**
     * Retrieves the explicit reason for validation failure.
     * @return an Optional block containing the reason string.
     */
    Optional<String> getReason();
}