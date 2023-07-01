package test;

import entity.User;
import org.junit.jupiter.api.*;
import utils.UserUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestLogin {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    private static List<User> database = new ArrayList<User>();
    @BeforeAll
    static void setup(){
        for (int i = 1; i <= 5; i++){
            database.add(new User("User" + i, "123456789", "User" +i));
        }
        //For System.out Testing
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @AfterAll
    static void teardown(){
        //For System.out Testing
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

//    @Test
//    void TestCase_01(){
//        Assertions.assertEquals(test,"hello");
//    }
    @Test
    @DisplayName("User is not exist")
    void TestCase_01(){
        Assertions.assertEquals(null, UserUtils.login(database, "1" , "0"));
    }
    @Test
    @DisplayName("Blank username")
    void TestCase_02(){
        Assertions.assertEquals(null, UserUtils.login(database, "", "123456789"));
    }

    @Test
    @DisplayName("Blank password")
    void TestCase_03(){
        Assertions.assertEquals(null, UserUtils.login(database, "User1", ""));
    }
    @Test
    @DisplayName("Username is not Exist")
    void TestCase_04(){
        Assertions.assertEquals(null, UserUtils.login(database, "1", "123456789"));
    }
    @Test
    @DisplayName("Password is not Exist")
    void TestCase_05(){
        Assertions.assertEquals(null, UserUtils.login(database, "User1", "12345678"));
    }
    @Test
    @DisplayName("Username have less than 3 digits")
    void TestCase_06(){
        Assertions.assertEquals(null, UserUtils.login(database, "Us", "12345678"));
    }
    @Test
    @DisplayName("Password have less than 3 digits")
    void TestCase_07(){
        Assertions.assertEquals(null, UserUtils.login(database, "User1", "12"));
    }
    @Test
    @DisplayName("Login successful")
    void TestCase_08(){
        User user = new User ("User1", "123456789", "User1");
        Assertions.assertEquals(user.getUsername(),  UserUtils.login(database, "User1", "123456789").getUsername());
    }
    @Test
    @DisplayName("Error checking: Hello ...!")
    void TestCase_09(){
        User user = UserUtils.login(database, "User1", "123456789");
        Assertions.assertEquals("Hello User1!", outContent.toString().split("\n")[8].trim());
    }
    @Test
    @DisplayName("Error checking: Wrong Password")
    void TestCase_10(){
        User user = UserUtils.login(database, "User1", "12345678");
        Assertions.assertEquals("Wrong password!", outContent.toString().split("\n")[9].trim());
    }
    @Test
    @DisplayName("Error checking: Wrong Username or Password")
    void TestCase_11(){
        User user = UserUtils.login(database, "User", "12345678");
        Assertions.assertEquals("Wrong Username or Password!", outContent.toString().split("\n")[10].trim());
    }
}
