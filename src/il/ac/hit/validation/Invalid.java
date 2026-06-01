package il.ac.hit.validation;
import java.util.Optional;
/**
 * Concrete implementation indicating a failed validation checkpoint with
 tracking context.
 */
public class Invalid implements ValidationResult {
    /** The explicit internal reason message explaining the failure vector. */
    private final String reason;
    /**
     * Constructs an invalid outcome bound to a specific tracking reason.
     * Reason for public: Must be accessible to combinator engines to generate
     failure nodes.
     * * @param reason the descriptive text parameter for system rejection.
     */
    public Invalid(final String reason) {
        this.reason = reason;
    }
    /**
     * {@inheritDoc}
     * Reason for public: Implements interface requirement specified by
     ValidationResult.
     */
    @Override
    public boolean isValid() {
        return false;
    }
    /**
     * {@inheritDoc}
     * Reason for public: Implements interface requirement specified by
     ValidationResult.
     */
    @Override
    public Optional<String> getReason() {
        return Optional.ofNullable(reason);
    }
}