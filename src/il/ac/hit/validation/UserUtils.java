package il.ac.hit.validation;
import java.util.Arrays;
import java.util.Comparator;
/**
 * Systems infrastructure utility layer offering custom sorting algorithms.
 * Implements the Template Method pattern via external functional Comparator
 hooks.
 */
public class UserUtils {
    /**
     * Private constructor to prevent instantiation of this utility class.
     * Reason for private: This class only provides static utility methods.
     */
    private UserUtils() {
        throw new AssertionError("Utility class should not be instantiated.");
    }
    /**
     * Executes specialized system array sorting tracking custom configuration
     options.
     * Reason for public: Exposed as a public infrastructure utility for sorting arrays.
     * * @param users targeted array container housing specific user elements.
     * @param comparator algorithm template configuration parameters block.
     */
    public static void sort(final User[] users, final Comparator<User> comparator) {
        if (users == null || comparator == null) {
            return;
        }
        Arrays.sort(users, comparator);
    }
}
