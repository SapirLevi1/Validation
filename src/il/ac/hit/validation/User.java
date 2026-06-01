package il.ac.hit.validation;
/**
 * Core component model representing base application users.
 */
public class User {
    /** The profile registration identifier string. */
    private final String username;
    /** The verified system email connection endpoint. */
    private final String email;
    /** The cryptographic validation token string for access profiles. */
    private final String password;
    /** The evaluated numeric classification constraint marker. */
    private final int age;
    /**
     * Instantiates a comprehensive structural User schema.
     * @param username identification mapping text.
     * @param email connection point address.
     * @param password security credential vector.
     * @param age age limit validation field.
     */
    public User(final String username, final String email, final String password,
                final int age) {
        // Map individual user context variables securely during object creation
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }
    /**
     * Retrieves the bound username parameter.
     * @return username tracking reference.
     */
    public String getUsername() { return username; }
    /**
     * Retrieves the bound email field.
     * @return email routing sequence.
     */
    public String getEmail() { return email; }
    /**
     * Retrieves the verification password credential tracking parameters.
     * @return password text blocks.
     */
    public String getPassword() { return password; }
    /**
     * Retrieves the evaluated user age tracking values.
     * @return age metric context.
     */
    public int getAge() { return age; }
}

