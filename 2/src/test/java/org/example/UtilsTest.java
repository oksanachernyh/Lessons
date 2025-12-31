package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    void testFactorial() {
        assertEquals(1, MathUtils.factorial(0));
        assertEquals(1, MathUtils.factorial(1));
        assertEquals(120, MathUtils.factorial(5));
        assertEquals(3628800, MathUtils.factorial(10));
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }


    @Test
    void testTriangleArea() {
        double area = GeometryUtils.triangleArea(3, 4, 5);
        assertEquals(6.0, area, 1e-6);
    }

    @Test
    void testTriangleInvalidSides() {
        assertThrows(IllegalArgumentException.class, () -> GeometryUtils.triangleArea(1, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> GeometryUtils.triangleArea(-1, 4, 5));
    }


    @Test
    void testAddition() {
        assertEquals(7, Calculator.add(3, 4));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, Calculator.subtract(5, 4));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, Calculator.multiply(4, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, Calculator.divide(10, 5));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
    }


    @Test
    void testCompare() {
        assertEquals(0, ComparisonUtils.compare(5, 5));
        assertTrue(ComparisonUtils.compare(3, 5) < 0);
        assertTrue(ComparisonUtils.compare(10, 2) > 0);
    }
}
