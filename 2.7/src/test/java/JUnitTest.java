import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitTest {

    //Факториал
    @Test
    @DisplayName("Тест факториала для нуля") void testFactorialZero() {
        assertEquals(1, MathOperations.factorial(0));
    }

    @Test
    @DisplayName("Тест факториала для единицы") void testFactorialOne() {
        assertEquals(1, MathOperations.factorial(1));
    }

    @Test
    @DisplayName("Тест факториала для положительных чисел") void testFactorialPositive() {
        assertEquals(2, MathOperations.factorial(2));
        assertEquals(6, MathOperations.factorial(3));
        assertEquals(24, MathOperations.factorial(4));
        assertEquals(120, MathOperations.factorial(5));
        assertEquals(720, MathOperations.factorial(6));
    }

    @Test
    @DisplayName("Тест факториала для отрицательного числа") void testFactorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MathOperations.factorial(-5));
        assertTrue(exception.getMessage().contains("Факториал не определён"));
    }


    //Площадь треугольника
    @Test
    @DisplayName("Тест площади треугольника с целыми числами") void testTriangleIntegers() {
        assertEquals(25.0, MathOperations.triangle(10, 5), 0.001);
        assertEquals(12.5, MathOperations.triangle(5, 5), 0.001);
    }

    @Test
    @DisplayName("Тест площади треугольника с дробными числами") void testTriangleDecimals() {
        assertEquals(0.5, MathOperations.triangle(1, 1), 0.001);
        assertEquals(50.0, MathOperations.triangle(10, 10), 0.001);
    }

    @Test
    @DisplayName("Тест площади треугольника с нулевым основанием") void testTriangleZeroBase() {
        assertThrows(IllegalArgumentException.class,() -> MathOperations.triangle(0, 5));
    }

    @Test
    @DisplayName("Тест площади треугольника с отрицательной высотой") void testTriangleNegativeHeight() {
        assertThrows(IllegalArgumentException.class,() -> MathOperations.triangle(10, -5));
    }


    //Арифметические операции
    //Сложение
    @Test
    @DisplayName("Тест сложения положительных чисел") void testAddPositive() {
        assertEquals(15, MathOperations.add(10, 5));
        assertEquals(7, MathOperations.add(3, 4));
    }

    @Test
    @DisplayName("Тест сложения отрицательных чисел") void testAddNegative() {
        assertEquals(-5, MathOperations.add(-10, 5));
        assertEquals(-15, MathOperations.add(-10, -5));
        assertEquals(0, MathOperations.add(5, -5));
    }

    @Test
    @DisplayName("Тест сложения с нулём") void testAddWithZero() {
        assertEquals(10, MathOperations.add(10, 0));
        assertEquals(5, MathOperations.add(0, 5));
        assertEquals(0, MathOperations.add(0, 0));
    }

    //Вычитание
    @Test
    @DisplayName("Тест вычитания положительных чисел") void testSubtractPositive() {
        assertEquals(5, MathOperations.add(10, 5));
        assertEquals(2, MathOperations.add(7, 5));
    }

    @Test
    @DisplayName("Тест вычитания отрицательных чисел") void testSubtractNegative() {
        assertEquals(-15, MathOperations.subtract(-10, 5));
        assertEquals(-5, MathOperations.subtract(-10, -5));
        assertEquals(10, MathOperations.subtract(5, -5));
    }

    @Test
    @DisplayName("Тест вычитания с нулём") void testSubtractWithZero() {
        assertEquals(10, MathOperations.subtract(10, 0));
        assertEquals(-5, MathOperations.subtract(0, 5));
        assertEquals(0, MathOperations.subtract(0, 0));
    }

    //Умножение
    @Test
    @DisplayName("Тест умножения положительных чисел") void testMultiplyPositive() {
        assertEquals(50, MathOperations.multiply(10, 5));
        assertEquals(12, MathOperations.multiply(3, 4));
    }

    @Test
    @DisplayName("Тест умножения отрицательных чисел") void testMultiplyNegative() {
        assertEquals(-50, MathOperations.multiply(10, -5));
        assertEquals(50, MathOperations.multiply(-10, -5));
        assertEquals(0, MathOperations.multiply(10, 0));
    }

    @Test
    @DisplayName("Тест умножения с нулём") void testMultiplyWithZero() {
        assertEquals(0, MathOperations.subtract(10, 0));
        assertEquals(0, MathOperations.subtract(0, 5));
        assertEquals(0, MathOperations.subtract(0, 0));
    }

    //Деление
    @Test
    @DisplayName("Тест деления положительных чисел") void testDividePositive() {
        assertEquals(2.0, MathOperations.divide(10, 5), 0.001);
        assertEquals(2.5, MathOperations.divide(5, 2),0.001);
    }

    @Test
    @DisplayName("Тест деления отрицательных чисел") void testDivideNegative() {
        assertEquals(-2.0, MathOperations.divide(10, -5),0.001);
        assertEquals(2.0, MathOperations.divide(-10, -5),0.001);
    }

    @Test
    @DisplayName("Тест деления с нулём в числителе") void testDivideWithZero() {
        assertEquals(0.0, MathOperations.divide(0, 5),0.001);
    }

    @Test
    @DisplayName("Тест деления на ноль") void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> MathOperations.divide(10, 0));
        assertTrue(exception.getMessage().contains("Деление на ноль"));
    }

    @Test
    @DisplayName("Тест деления целых чисел на результат double") void testDivideIntegersToDouble() {
        assertEquals(3.333, MathOperations.divide(10, 3),0.001);
        assertEquals(0.333, MathOperations.divide(1, 3),0.001);
    }


    //Сравнение чисел
    @Test
    @DisplayName("Тест сравнения, когда первое число больше") void testCompareFirst() {
        assertEquals("10 > 5", MathOperations.compare(10, 5));
        assertEquals("100 > 50", MathOperations.compare(100, 50));
        assertEquals("1 > 0", MathOperations.compare(1, 0));
    }

    @Test
    @DisplayName("Тест сравнения, когда второе число больше") void testCompareSecond() {
        assertEquals("5 < 10", MathOperations.compare(5, 10));
        assertEquals("0 < 1", MathOperations.compare(0, 1));
        assertEquals("-5 < 5", MathOperations.compare(-5, 5));
    }

    @Test
    @DisplayName("Тест сравнения, когда числа равны") void testCompareEqual() {
        assertEquals("7 = 7", MathOperations.compare(7, 7));
        assertEquals("0 = 0", MathOperations.compare(0, 0));
        assertEquals("-5 = -5", MathOperations.compare(-5, -5));
    }

    @Test
    @DisplayName("Тест сравнения отрицательных чисел") void testCompareNegative() {
        assertEquals("-10 < -5", MathOperations.compare(-10, -5));
        assertEquals("-1 > -10", MathOperations.compare(-1, -10));
        assertEquals("-5 < 0", MathOperations.compare(-5, 0));
    }
}
