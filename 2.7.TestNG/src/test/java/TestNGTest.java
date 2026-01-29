import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;

public class TestNGTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("=== Начало теста ===");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("=== Конец теста ===\n");
    }


    //Факториал
    @Test(groups = {"factorial", "basic"})
    public void testFactorialZero() {
        System.out.println("Тест: факториал 0");
        assertEquals(MathOperations.factorial(0), 1L);
    }

    @Test(groups = {"factorial", "basic"})
    public void testFactorialOne() {
        System.out.println("Тест: факториал 1");
        assertEquals(MathOperations.factorial(1), 1L);
    }

    @Test(groups = {"factorial", "positive"})
    public void testFactorialSmallNumbers() {
        System.out.println("Тест: факториал небольших чисел");
        assertEquals(MathOperations.factorial(2), 2L);
        assertEquals(MathOperations.factorial(3), 6L);
        assertEquals(MathOperations.factorial(4), 24L);
        assertEquals(MathOperations.factorial(5), 120L);
    }

    @Test(groups = {"factorial", "positive"})
    public void testFactorialMediumNumbers() {
        System.out.println("Тест: факториал средних чисел");
        assertEquals(MathOperations.factorial(6), 720L);
        assertEquals(MathOperations.factorial(7), 5040L);
        assertEquals(MathOperations.factorial(8), 40320L);
    }

    @Test(groups = {"factorial", "negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        System.out.println("Тест: факториал отрицательного числа");
        MathOperations.factorial(-5);
    }

    @Test(groups = {"factorial", "negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialMinusOne() {
        System.out.println("Тест: факториал -1");
        MathOperations.factorial(-1);
    }


    //Площадь треугольника
    @Test(groups = {"triangle", "basic"})
    public void testTriangleAreaBasic() {
        System.out.println("Тест: базовая площадь треугольника");
        assertEquals(MathOperations.triangle(10, 5), 25.0);
        assertEquals(MathOperations.triangle(5, 5), 12.5);
    }

    @Test(groups = {"triangle", "basic"})
    public void testTriangleAreaUnit() {
        System.out.println("Тест: площадь треугольника единичного размера");
        assertEquals(MathOperations.triangle(1, 1), 0.5);
    }

    @Test(groups = {"triangle", "large"})
    public void testTriangleAreaLarge() {
        System.out.println("Тест: площадь большого треугольника");
        assertEquals(MathOperations.triangle(100, 50), 2500.0);
        assertEquals(MathOperations.triangle(50, 100), 2500.0);
    }

    @Test(groups = {"triangle", "negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaZeroBase() {
        System.out.println("Тест: площадь с нулевым основанием");
        MathOperations.triangle(0, 10);
    }

    @Test(groups = {"triangle", "negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaZeroHeight() {
        System.out.println("Тест: площадь с нулевой высотой");
        MathOperations.triangle(10, 0);
    }

    @Test(groups = {"triangle", "negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaNegativeBase() {
        System.out.println("Тест: площадь с отрицательным основанием");
        MathOperations.triangle(-10, 5);
    }


    //Арифметические операции
    //Сложение
    @Test(groups = {"arithmetic", "addition"})
    public void testAddPositive() {
        System.out.println("Тест: сложение положительных чисел");
        assertEquals(MathOperations.add(10, 5), 15);
        assertEquals(MathOperations.add(3, 4), 7);
    }

    @Test(groups = {"arithmetic", "addition"})
    public void testAddNegative() {
        System.out.println("Тест: сложение отрицательных чисел");
        assertEquals(MathOperations.add(-10, 5), -5);
        assertEquals(MathOperations.add(10, -5), 5);
        assertEquals(MathOperations.add(-10, -5), -15);
    }

    @Test(groups = {"arithmetic", "addition"})
    public void testAddZero() {
        System.out.println("Тест: сложение с нулем");
        assertEquals(MathOperations.add(10, 0), 10);
        assertEquals(MathOperations.add(0, 5), 5);
        assertEquals(MathOperations.add(0, 0), 0);
    }

    //Вычитание
    @Test(groups = {"arithmetic", "subtraction"})
    public void testSubtractPositive() {
        System.out.println("Тест: вычитание положительных чисел");
        assertEquals(MathOperations.subtract(10, 5), 5);
        assertEquals(MathOperations.subtract(7, 3), 4);
    }

    @Test(groups = {"arithmetic", "subtraction"})
    public void testSubtractNegative() {
        System.out.println("Тест: вычитание отрицательных чисел");
        assertEquals(MathOperations.subtract(10, -5), 15);
        assertEquals(MathOperations.subtract(-10, 5), -15);
        assertEquals(MathOperations.subtract(-10, -5), -5);
    }

    @Test(groups = {"arithmetic", "subtraction"})
    public void testSubtractZero() {
        System.out.println("Тест: вычитание с нулем");
        assertEquals(MathOperations.subtract(10, 0), 10);
        assertEquals(MathOperations.subtract(0, 5), -5);
        assertEquals(MathOperations.subtract(0, 0), 0);
    }

    //Умножение
    @Test(groups = {"arithmetic", "multiplication"})
    public void testMultiplyPositive() {
        System.out.println("Тест: умножение положительных чисел");
        assertEquals(MathOperations.multiply(10, 5), 50);
        assertEquals(MathOperations.multiply(3, 4), 12);
    }

    @Test(groups = {"arithmetic", "multiplication"})
    public void testMultiplyNegative() {
        System.out.println("Тест: умножение отрицательных чисел");
        assertEquals(MathOperations.multiply(10, -5), -50);
        assertEquals(MathOperations.multiply(-10, 5), -50);
        assertEquals(MathOperations.multiply(-10, -5), 50);
    }

    @Test(groups = {"arithmetic", "multiplication"})
    public void testMultiplyZero() {
        System.out.println("Тест: умножение на ноль");
        assertEquals(MathOperations.multiply(10, 0), 0);
        assertEquals(MathOperations.multiply(0, 5), 0);
        assertEquals(MathOperations.multiply(0, 0), 0);
    }

    //Деление
    @Test(groups = {"arithmetic", "division"})
    public void testDividePositive() {
        System.out.println("Тест: деление положительных чисел");
        assertEquals(MathOperations.divide(10, 5), 2.0);
        assertEquals(MathOperations.divide(5, 2), 2.5);
    }

    @Test(groups = {"arithmetic", "division"})
    public void testDivideNegative() {
        System.out.println("Тест: деление отрицательных чисел");
        assertEquals(MathOperations.divide(10, -5), -2.0);
        assertEquals(MathOperations.divide(-10, 5), -2.0);
        assertEquals(MathOperations.divide(-10, -5), 2.0);
    }

    @Test(groups = {"arithmetic", "division"})
    public void testDivideZeroNumerator() {
        System.out.println("Тест: деление нуля на число");
        assertEquals(MathOperations.divide(0, 5), 0.0);
        assertEquals(MathOperations.divide(0, -5), 0.0);
    }

    @Test(groups = {"arithmetic", "division", "negative"}, expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        System.out.println("Тест: деление на ноль");
        MathOperations.divide(10, 0);
    }

    @Test(groups = {"arithmetic", "division"})
    public void testDivideFractions() {
        System.out.println("Тест: деление с дробным результатом");
        assertEquals(MathOperations.divide(1, 3), 0.3333333333333333);
        assertEquals(MathOperations.divide(10, 3), 3.3333333333333335);
    }


    //Сравнение чисел
    @Test(groups = {"comparison", "basic"})
    public void testCompareFirstGreater() {
        System.out.println("Тест: сравнение, первое число больше");
        assertEquals(MathOperations.compare(10, 5), "10 больше 5");
        assertEquals(MathOperations.compare(100, 50), "100 больше 50");
    }

    @Test(groups = {"comparison", "basic"})
    public void testCompareSecondGreater() {
        System.out.println("Тест: сравнение, второе число больше");
        assertEquals(MathOperations.compare(5, 10), "5 меньше 10");
        assertEquals(MathOperations.compare(0, 1), "0 меньше 1");
    }

    @Test(groups = {"comparison", "basic"})
    public void testCompareEqual() {
        System.out.println("Тест: сравнение равных чисел");
        assertEquals(MathOperations.compare(7, 7), "Числа равны");
        assertEquals(MathOperations.compare(0, 0), "Числа равны");
        assertEquals(MathOperations.compare(-5, -5), "Числа равны");
    }

    @Test(groups = {"comparison", "advanced"})
    public void testCompareNegativeNumbers() {
        System.out.println("Тест: сравнение отрицательных чисел");
        assertEquals(MathOperations.compare(-10, -5), "-10 меньше -5");
        assertEquals(MathOperations.compare(-5, -10), "-5 больше -10");
        assertEquals(MathOperations.compare(-5, 0), "-5 меньше 0");
        assertEquals(MathOperations.compare(0, -5), "0 больше -5");
    }

    @Test(groups = {"comparison", "edge"})
    public void testCompareEdgeCases() {
        System.out.println("Тест: граничные случаи сравнения");
        assertEquals(MathOperations.compare(Integer.MAX_VALUE, Integer.MAX_VALUE - 1), "2147483647 больше 2147483646");
        assertEquals(MathOperations.compare(Integer.MIN_VALUE, Integer.MIN_VALUE + 1), "-2147483648 меньше -2147483647");
    }
}