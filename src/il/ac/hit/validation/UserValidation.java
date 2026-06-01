package il.ac.hit.validation;
import java.util.function.Function;
/**
 * Core interface architecture mapping the Combinator design pattern for
 security evaluation routines.
 */
@FunctionalInterface
public interface UserValidation extends Function<User, ValidationResult> {
    // --- Instance Combinator Rule Blocks ---
    /**
     * Merges independent rules conditionally through logical strict AND
     verification.
     * @param other target evaluation rule to concatenate.
     * @return combined validation rule layout wrapper.
     */
    default UserValidation and(final UserValidation other) {
        // Returns a lambda instance tracking logical sequencing boundaries
        return user -> {
            final ValidationResult result = this.apply(user);
            // Steps deep into the next validation chain only if the current block passes
            return result.isValid() ? other.apply(user) : result;
        };
    }
    /**
     * Merges independent rules conditionally through logical fallback OR
     verification.
     * @param other target evaluation rule to concatenate.
     * @return combined validation rule layout wrapper.
     */
    default UserValidation or(final UserValidation other) {
        // Processes alternative evaluation vectors down current processing stacks
        return user -> {
            final ValidationResult result = this.apply(user);
            // Delivers initial successful validation tracking references or defaults downstream
            return result.isValid() ? result : other.apply(user);
        };
    }
    /**
     * Merges independent rules conditionally through logical exclusive XOR
     verification.
     * @param other target evaluation rule to concatenate.
     * @return combined validation rule layout wrapper.
     */
    default UserValidation xor(final UserValidation other) {
        // Assesses logical validation uniqueness checks across separate constraints
        return user -> {
            final ValidationResult res1 = this.apply(user);
            final ValidationResult res2 = other.apply(user);
            // Measures if precisely one specific validation track is successfully resolved
            if (res1.isValid() ^ res2.isValid()) {
                // Pinpoints the specific passing result node to feed back upstream
                return res1.isValid() ? res1 : res2;
            }
            // Drops out an tracking rejection flag if rules match identical validation statuses
            return new Invalid("XOR validation failed: both rules evaluate to same status");
        };
    }
    // --- Static Combinator Aggregation Blocks ---
    /**
     * Demands absolute successful compliance checks across every parameter
     passed down.
     * @param validations variable argument collection of criteria.
     * @return multi-tier aggregated validation controller.
     */
    static UserValidation all(final UserValidation... validations) {
        // Iterates through complex multi-criteria lists dynamically
        return user -> {
            for (final UserValidation validation : validations) {
                final ValidationResult result = validation.apply(user);
                // Halts sequence verification pathways instantly upon intercepting validation warnings
                if (!result.isValid()) return result;
            }
            // Issues a valid passing token if every validation rule scales safely
            return new Valid();
        };
    }
    /**
     * Demands absolute failure compliance checks across every parameter
     passed down.
     * @param validations variable argument collection of criteria.
     * @return multi-tier aggregated validation controller.
     */
    static UserValidation none(final UserValidation... validations) {
        // Loops through inverted evaluation configurations sequentially
        return user -> {
            for (final UserValidation validation : validations) {
                final ValidationResult result = validation.apply(user);
                // Triggers structural failure updates if an isolated parameter unexpectedly succeeds
                if (result.isValid()) {
                    return new Invalid("None condition failed: A validation rule evaluation succeeded");
                }
            }
            // Resolves validation tracking successfully if all conditions fail to verify
            return new Valid();
        };
    }
    // --- Concrete Processing Rule Nodes ---
    /**
     * Standard verification rule monitoring target regional extensions on emails.
     * @return evaluation condition predicate.
     */
    static UserValidation emailEndsWithIL() {
        // Confirms local infrastructure suffix formatting parameters are present
        return user -> user.getEmail() != null && user.getEmail().endsWith("il") ?
                new Valid() : new Invalid("Email does not end with 'il'");
    }
    /**
     * Standard verification rule measuring minimum length properties on emails.
     * @return evaluation condition predicate.
     */
    static UserValidation emailLengthBiggerThan10() {
        // Blocks spoofing accounts by filtering out text strings below baseline limits
        return user -> user.getEmail() != null && user.getEmail().length() > 10 ?
                new Valid() : new Invalid("Email length is not bigger than 10");
    }
    /**
     * Standard verification rule measuring minimum length properties on
     passwords.
     * @return evaluation condition predicate.
     */
    static UserValidation passwordLengthBiggerThan8() {
        // Confirms base system structural security properties meet size requirements
        return user -> user.getPassword() != null && user.getPassword().length() > 8 ?
                new Valid() : new Invalid("Password length is not bigger than 8");
    }
    /**
     * Standard verification rule maintaining clean alphanumeric parameters on
     passwords.
     * @return evaluation condition predicate.
     */
    static UserValidation passwordIncludesLettersNumbersOnly() {
        // Parses character blocks securely using optimized regex expression validation blocks
        return user -> user.getPassword() != null &&
                user.getPassword().matches("^[a-zA-Z0-9]+$") ?
                new Valid() : new Invalid("Password must include letters and numbers only");
    }
    /**
     * Standard verification rule checking specialized characters within passwords.
     * @return evaluation condition predicate.
     */
    static UserValidation passwordIncludesDollarSign() {
        // Inspects input text bounds for missing security characters
        return user -> user.getPassword() != null && user.getPassword().contains("$")
                ?
                new Valid() : new Invalid("Password must include a dollar sign ($)");
    }
    /**
     * Standard verification rule enforcing structural insulation between profile data
     nodes.
     * @return evaluation condition predicate.
     */
    static UserValidation passwordIsDifferentFromUsername() {
        // Blocks baseline credential matching shortcuts to lower hacking vectors
        return user -> user.getPassword() != null &&
                !user.getPassword().equals(user.getUsername()) ?
                new Valid() : new Invalid("Password must be different from username");
    }
    /**
     * Standard verification rule managing maturity tracking protocols across
     records.
     * @return evaluation condition predicate.
     */
    static UserValidation ageBiggerThan18() {
        // Enforces compliance workflows blocking registration fields to under-age assets
        return user -> user.getAge() > 18 ?
                new Valid() : new Invalid("Age must be greater than 18");
    }
    /**
     * Standard verification rule measuring minimum length properties on
     usernames.
     * @return evaluation condition predicate.
     */
    static UserValidation usernameLengthBiggerThan8() {
        // Coordinates storage data formatting rules checking minimum identity string lengths
        return user -> user.getUsername() != null && user.getUsername().length() > 8
                ?
                new Valid() : new Invalid("Username length is not bigger than 8");
    }
}
