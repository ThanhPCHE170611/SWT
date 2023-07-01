package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberUtils;

public class TestIsPalindromeFunction {

    @Test
    @DisplayName("Normal - Palindrome Number")
    void testCase_01() {
        boolean result = NumberUtils.isPalindrome(121);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Normal - Non-Palindrome Number")
    void testCase_02() {
        boolean result = NumberUtils.isPalindrome(12345);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Normal - Single Digit Number")
    void testCase_03() {
        boolean result = NumberUtils.isPalindrome(7);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Normal - Large Palindrome Number")
    void testCase_04() {
        boolean result = NumberUtils.isPalindrome(1234321);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Normal - Large Non-Palindrome Number")
    void testCase_05() {
        boolean result = NumberUtils.isPalindrome(1234567);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Normal - Leading Zeros in Palindrome Number")
    void testCase_06() {
        boolean result = NumberUtils.isPalindrome(001100);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Normal - Leading Zeros in Non-Palindrome Number")
    void testCase_07() {
        boolean result = NumberUtils.isPalindrome(001234);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Normal - Zero")
    void testCase_08() {
        boolean result = NumberUtils.isPalindrome(0);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Abnormal - Negative Number")
    void testCase_09() {
        boolean result = NumberUtils.isPalindrome(-121);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Abnormal - Negative Non-Palindrome Number")
    void testCase_10() {
        boolean result = NumberUtils.isPalindrome(-12345);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Abnormal - Negative Palindrome Number")
    void testCase_11() {
        boolean result = NumberUtils.isPalindrome(-12321);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Abnormal - Negative Single Digit Number")
    void testCase_12() {
        boolean result = NumberUtils.isPalindrome(-5);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Boundary - Maximum Integer Value")
    void testCase_13() {
        boolean result = NumberUtils.isPalindrome(2147483647);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Boundary - Minimum Integer Value")
    void testCase_14() {
        boolean result = NumberUtils.isPalindrome(-2147483648);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Boundary - Single Digit Palindrome Number")
    void testCase_15() {
        boolean result = NumberUtils.isPalindrome(9);
        Assertions.assertTrue(result);
    }
}

