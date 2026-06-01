package il.ac.hit.validation;
/**
 * Specific application user representation covering platinum service profiles.
 */
public class PlatinumUser extends User {
    /**
     * Maps base structural properties for platinum tier profiles.
     * @param username identification mapping text.
     * @param email connection point address.
     * @param password security credential vector.
     * @param age age limit validation field.
     */
    public PlatinumUser(final String username, final String email, final String
            password, final int age) {
        // Grants deep enterprise execution tokens through standardized structures
        super(username, email, password, age);
    }
}
