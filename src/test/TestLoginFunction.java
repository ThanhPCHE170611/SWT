package test;

import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.UserUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestLoginFunction {
    private List<User> database;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        database = new ArrayList<>();
        database.add(new User("john", "password123", "John Smith"));

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("User exists and provides correct username and password") // Normal test case
    void testCase_01() {
        User result = UserUtils.login(database, "john", "password123");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Hello John Smith!", getConsoleOutput());
    }

    // Test cases for abnormal conditions

    @Test
    @DisplayName("User exists and provides incorrect password") // Abnormal test case
    void testCase_02() {
        User result = UserUtils.login(database, "john", "wrongpassword");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User is not exist") // Abnormal test case
    void testCase_03() {
        User result = UserUtils.login(database, "nonexistent", "password123");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides incorrect username and empty password") // Abnormal test case
    void testCase_04() {
        User result = UserUtils.login(database, "incorrect", "");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides incorrect username and null password") // Abnormal test case
    void testCase_05() {
        User result = UserUtils.login(database, "incorrect", null);

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides empty username and incorrect password") // Abnormal test case
    void testCase_06() {
        User result = UserUtils.login(database, "", "wrongpassword");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides null username and incorrect password") // Abnormal test case
    void testCase_07() {
        User result = UserUtils.login(database, null, "wrongpassword");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides empty username and empty password") // Abnormal test case
    void testCase_08() {
        User result = UserUtils.login(database, "", "");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides null username and null password") // Abnormal test case
    void testCase_09() {
        User result = UserUtils.login(database, null, null);

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides incorrect username and incorrect password") // Abnormal test case
    void testCase_10() {
        User result = UserUtils.login(database, "incorrect", "wrongpassword");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides incorrect username and correct password") // Abnormal test case
    void testCase_11() {
        User result = UserUtils.login(database, "incorrect", "password123");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides correct username and empty password") // Abnormal test case
    void testCase_12() {
        User result = UserUtils.login(database, "john", "");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists but provides correct username and null password") // Abnormal test case
    void testCase_13() {
        User result = UserUtils.login(database, "john", null);

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    // Test cases for boundary conditions

    @Test
    @DisplayName("Empty database, empty username, and empty password") // Boundary test case
    void testCase_14() {
        List<User> emptyDatabase = new ArrayList<>();
        User result = UserUtils.login(emptyDatabase, "", "");

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }

    @Test
    @DisplayName("Empty database, null username, and null password") // Boundary test case
    void testCase_15() {
        List<User> emptyDatabase = new ArrayList<>();
        User result = UserUtils.login(emptyDatabase, null, null);

        Assertions.assertNull(result);
        Assertions.assertEquals("Wrong Username or Password!", getConsoleOutput());
    }
    @Test
    @DisplayName("User exists and provides correct username and password (case-insensitive)") // Normal test case
    void testCase_16() {
        User result = UserUtils.login(database, "JOHN", "PASSWORD123");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Hello John Smith!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists and provides correct username and password (different cases)") // Normal test case
    void testCase_17() {
        User result = UserUtils.login(database, "jOhN", "pAsSwOrD123");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Hello John Smith!", getConsoleOutput());
    }

    @Test
    @DisplayName("User exists and provides correct username and password (leading/trailing whitespace)") // Normal test case
    void testCase_18() {
        User result = UserUtils.login(database, "   john   ", "   password123   ");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Hello John Smith!", getConsoleOutput());
    }


    private String getConsoleOutput() {
        return outputStream.toString().trim();
    }
}
