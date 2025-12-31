package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathTests {

    // Тесты для факториала
    @Test
    public void testFactorial() {
        Assert.assertEquals(MathUtils.factorial(0), 1);
        Assert.assertEquals(MathUtils.factorial(1), 1);
        Assert.assertEquals(MathUtils.factorial(5), 120);
        Assert.assertEquals(MathUtils.factorial(10), 3628800);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        MathUtils.factorial(-1);
    }

    // Тесты для площади треугольника
    @Test
    public void testCalculateArea() {
        double area = GeometryUtils.triangleArea(3, 4, 5);
        Assert.assertEquals(area, 6.0, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaInvalidSides() {
        GeometryUtils.triangleArea(1, 2, 3); // не существует треугольника
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaNegativeSide() {
        GeometryUtils.triangleArea(-3, 4, 5);
    }

    // Тесты для арифметических операций
    @Test
    public void testArithmeticOperations() {
        Assert.assertEquals(Calculator.add(3, 5), 8);
        Assert.assertEquals(Calculator.subtract(10, 4), 6);
        Assert.assertEquals(Calculator.multiply(6, 7), 42);
        Assert.assertEquals(Calculator.divide(20, 4), 5.0, 0.0001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator.divide(10, 0);
    }

    // Тесты для сравнения чисел
    @Test
    public void testCompare() {
        Assert.assertEquals(ComparisonUtils.compare(5, 3), 1);
        Assert.assertEquals(ComparisonUtils.compare(3, 5), -1);
        Assert.assertEquals(ComparisonUtils.compare(4, 4), 0);
    }
}
