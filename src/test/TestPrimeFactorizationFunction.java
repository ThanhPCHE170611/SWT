package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberUtils;

import java.util.HashMap;
import java.util.Map;

public class TestPrimeFactorizationFunction {

    @Test
    @DisplayName("Normal - Prime Number")
    void testCase_01() {
        int number = 13;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(13, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Composite Number")
    void testCase_02() {
        int number = 24;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 3);
        expectedFactors.put(3, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Large Prime Number")
    void testCase_03() {
        int number = 997;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(997, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Large Composite Number")
    void testCase_04() {
        int number = 12345;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(3, 1);
        expectedFactors.put(5, 1);
        expectedFactors.put(823, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Number with Multiple Prime Factors")
    void testCase_05() {
        int number = 210;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 1);
        expectedFactors.put(3, 1);
        expectedFactors.put(5, 1);
        expectedFactors.put(7, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Number with Repeated Prime Factors")
    void testCase_06() {
        int number = 64;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 6);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Number with Single Prime Factor")
    void testCase_07() {
        int number = 11;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(11, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Number with Prime Factor Repeated Twice")
    void testCase_08() {
        int number = 121;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(11, 2);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Number with Prime Factors and Composite Factors")
    void testCase_09() {
        int number = 360;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 3);
        expectedFactors.put(3, 2);
        expectedFactors.put(5, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Normal - Number with Prime Factors and Repeated Composite Factors")
    void testCase_10() {
        int number = 1440;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 5);
        expectedFactors.put(3, 1);
        expectedFactors.put(5, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Abnormal - Negative Number")
    void testCase_11() {
        int number = -36;
        Map<Integer, Integer> expectedFactors = new HashMap<>();

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Abnormal - Zero")
    void testCase_12() {
        int number = 0;
        Map<Integer, Integer> expectedFactors = new HashMap<>();

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Abnormal - Number with No Prime Factors")
    void testCase_13() {
        int number = 50;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 1);
        expectedFactors.put(5, 2);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertNotEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Abnormal - Prime Number as Input")
    void testCase_14() {
        int number = 17;
        Map<Integer, Integer> expectedFactors = new HashMap<>();

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertNotEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Abnormal - Large Prime Number as Input")
    void testCase_15() {
        int number = 9973;
        Map<Integer, Integer> expectedFactors = new HashMap<>();

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertNotEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Abnormal - Negative Composite Number")
    void testCase_16() {
        int number = -84;
        Map<Integer, Integer> expectedFactors = new HashMap<>();

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Abnormal - Composite Number with Zero as Factor")
    void testCase_17() {
        int number = 1500;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 2);
        expectedFactors.put(3, 1);
        expectedFactors.put(5, 3);
        expectedFactors.put(0, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertNotEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Boundary - Smallest Prime Number")
    void testCase_18() {
        int number = 2;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Boundary - Smallest Composite Number")
    void testCase_19() {
        int number = 4;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(2, 2);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }

    @Test
    @DisplayName("Boundary - Maximum Integer Value")
    void testCase_20() {
        int number = Integer.MAX_VALUE;
        Map<Integer, Integer> expectedFactors = new HashMap<>();
        expectedFactors.put(Integer.MAX_VALUE, 1);

        Map<Integer, Integer> factors = NumberUtils.primeFactorization(number);
        Assertions.assertEquals(expectedFactors, factors);
    }
}

