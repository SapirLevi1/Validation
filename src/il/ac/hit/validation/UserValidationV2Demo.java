package il.ac.hit.validation;
/**
 * Orchestration system class acting as the primary execution demo for validation
 workflows.
 */
public class UserValidationV2Demo {
    /**
     * Private constructor to prevent instantiation of the main orchestration demo
     class.
     * Reason for private: This class only houses the static main execution hook.
     */
    private UserValidationV2Demo() {
        throw new AssertionError("Demo entry class should not be instantiated.");
    }
    /**
     * Operational engine start mechanism invoking test validations across a
     specific mock user.
     * Reason for public: Must be public as required by the JVM launch
     specification.
     * * @param args array arguments block mapped from terminal calls.
     */
    public static void main(String[] args) {
        final User user = new User("admin", "admin@#yzw.co.il", "abc123", 34);
        final UserValidation validation1 =
                UserValidation.emailLengthBiggerThan10();
        final UserValidation validation2 = UserValidation.emailEndsWithIL();
        final ValidationResult result = (validation1.and(validation2)).apply(user);
        if(result.isValid()) {
            System.out.println("User is valid");
        } else {
            System.out.println("User is not valid");
        }
    }
}
