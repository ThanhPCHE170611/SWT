package test;

import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.UserUtils;

public class TestChangePasswordFunction {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("john", "password123", "John Smith");
    }

    @Test
    @DisplayName("User provides correct old password") // Normal test case
    void testCase_01() {
        User result = UserUtils.changePassword(user, "password123", "newpassword");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("newpassword", result.getPassword());
    }

    @Test
    @DisplayName("User provides incorrect old password") // Normal test case
    void testCase_02() {
        User result = UserUtils.changePassword(user, "wrongpassword", "newpassword");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides null old password") // Abnormal test case
    void testCase_03() {
        User result = UserUtils.changePassword(user, null, "newpassword");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides empty old password") // Abnormal test case
    void testCase_04() {
        User result = UserUtils.changePassword(user, "", "newpassword");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides correct old password and null new password") // Abnormal test case
    void testCase_05() {
        User result = UserUtils.changePassword(user, "password123", null);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides correct old password and empty new password") // Abnormal test case
    void testCase_06() {
        User result = UserUtils.changePassword(user, "password123", "");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides incorrect old password and null new password") // Abnormal test case
    void testCase_07() {
        User result = UserUtils.changePassword(user, "wrongpassword", null);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides incorrect old password and empty new password") // Abnormal test case
    void testCase_08() {
        User result = UserUtils.changePassword(user, "wrongpassword", "");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides null user and old password") // Abnormal test case
    void testCase_09() {
        User result = UserUtils.changePassword(null, "password123", "newpassword");

        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("User provides null user, old password, and new password") // Abnormal test case
    void testCase_10() {
        User result = UserUtils.changePassword(null, "password123", null);

        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("User provides correct old password and new password") // Normal test case
    void testCase_11() {
        User result = UserUtils.changePassword(user, "password123", "newpassword");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("newpassword", result.getPassword());
    }

    @Test
    @DisplayName("User provides correct old password and same new password") // Normal test case
    void testCase_12() {
        User result = UserUtils.changePassword(user, "password123", "password123");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides empty old password and new password") // Abnormal test case
    void testCase_13() {
        User result = UserUtils.changePassword(user, "", "newpassword");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides null old password and new password") // Abnormal test case
    void testCase_14() {
        User result = UserUtils.changePassword(user, null, "newpassword");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }

    @Test
    @DisplayName("User provides empty old password and null new password") // Abnormal test case
    void testCase_15() {
        User result = UserUtils.changePassword(user, "", null);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("password123", result.getPassword());
    }
}
