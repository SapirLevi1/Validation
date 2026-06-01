package il.ac.hit.validation;
/**
 * Specific application user representation covering standard basic service
 profiles.
 */
public class BasicUser extends User {
    /**
     * Maps base structural properties for standard tier basic users.
     * @param username identification mapping text.
     * @param email connection point address.
     * @param password security credential vector.
     * @param age age limit validation field.
     */
    public BasicUser(final String username, final String email, final String
            password, final int age) {
        // Delegates parameter mapping routines straight to the super constructor layer
        super(username, email, password, age);
    }
}