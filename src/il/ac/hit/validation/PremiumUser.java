package il.ac.hit.validation;
/**
 * Specific application user representation covering premium service profiles.
 */
public class PremiumUser extends User {
    /**
     * Maps base structural properties for premium tier users.
     * @param username identification mapping text.
     * @param email connection point address.
     * @param password security credential vector.
     * @param age age limit validation field.
     */
    public PremiumUser(final String username, final String email, final String
            password, final int age) {
        // Maps extended access contexts securely through base properties
        super(username, email, password, age);
    }
}