package il.ac.hit.validation;
import java.util.Optional;
/**
 * Concrete implementation indicating a successful validation checkpoint.
 */
public class Valid implements ValidationResult {
    /**
     * Default constructor for the Valid result state.
     * Reason for public: Must be accessible package-wide/externally to be
     instantiated by combinator rules.
     */
    public Valid() {
        // Initializes a positive validation tracking state
    }
    /**
     * {@inheritDoc}
     * Reason for public: Implements interface requirement specified by
     ValidationResult.
     */
    @Override
    public boolean isValid() {
        return true;
    }
    /**
     * {@inheritDoc}
     * Reason for public: Implements interface requirement specified by
     ValidationResult.
     */
    @Override
    public Optional<String> getReason() {
        return Optional.empty();
    }
}

