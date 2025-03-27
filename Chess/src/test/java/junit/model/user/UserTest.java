package junit.model.user;
import org.falcon.model.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User testUser = new User();
    @Test
    public void testConstructor() {
        assertTrue(this.testUser != null);
    }
}
