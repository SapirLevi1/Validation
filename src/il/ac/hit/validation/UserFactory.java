package il.ac.hit.validation;
/**
 * Concrete object factory managing instantiation logic across individual user
 subclasses.
 * Correctly implements the Factory Method design pattern.
 */
public class UserFactory {
    /**
     * Private constructor to prevent instantiation of this factory utility class.
     * Reason for private: This class only provides static factory methods.
     */
    private UserFactory() {
        throw new AssertionError("Factory class should not be instantiated.");
    }
    /**
     * Evaluates concrete instantiation requests mapping specific user
     configurations.
     * Reason for public: Exposed as a public API factory method for application
     usage.
     * * @param type target subtype matching string context.
     * @param username identification mapping text.
     * @param email connection point address.
     * @param password security credential vector.
     * @param age age limit validation field.
     * @return customized concrete User sub-entity instance.
     */
    public static User create(final String type, final String username, final String
            email, final String password, final int age) {
        if (type == null) {
            throw new IllegalArgumentException("User type cannot be null");
        }
        return switch (type.toLowerCase().trim()) {
            case "basic" -> new BasicUser(username, email, password, age);
            case "premium" -> new PremiumUser(username, email, password, age);
            case "platinum" -> new PlatinumUser(username, email, password, age);
            default -> throw new IllegalArgumentException("Unknown user type: " +
                    type);
        };
    }
}