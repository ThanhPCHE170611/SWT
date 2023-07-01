package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static utils.NumberUtils.isPrime;

public class TestIsPrimeFunction {

    @Test
    @DisplayName("Number is a prime number") // Normal test case
    void testCase_01() {
        boolean result = isPrime(7);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Number is not a prime number") // Normal test case
    void testCase_02() {
        boolean result = isPrime(10);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is 2") // Boundary test case
    void testCase_03() {
        boolean result = isPrime(2);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Number is 1") // Boundary test case
    void testCase_04() {
        boolean result = isPrime(1);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is a negative prime number") // Abnormal test case
    void testCase_05() {
        boolean result = isPrime(-7);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is a negative non-prime number") // Abnormal test case
    void testCase_06() {
        boolean result = isPrime(-10);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is zero") // Abnormal test case
    void testCase_07() {
        boolean result = isPrime(0);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is a large prime number") // Normal test case
    void testCase_08() {
        boolean result = isPrime(997);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Number is a large non-prime number") // Normal test case
    void testCase_09() {
        boolean result = isPrime(1000);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is the maximum value of an integer") // Boundary test case
    void testCase_10() {
        boolean result = isPrime(Integer.MAX_VALUE);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Number is the minimum value of an integer") // Boundary test case
    void testCase_11() {
        boolean result = isPrime(Integer.MIN_VALUE);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is a string") // Abnormal test case
    void testCase_12() {
        boolean result = isPrime(Integer.parseInt("12"));
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Number is null") // Abnormal test case
    void testCase_13() {
        Integer number = null;
        Assertions.assertThrows(NullPointerException.class, () -> isPrime(number));
    }

    @Test
    @DisplayName("Number is negative infinity") // Abnormal test case
    void testCase_14() {
        boolean result = isPrime(Integer.MIN_VALUE);
        Assertions.assertFalse(result);
    }
}
