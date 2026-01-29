package Math;

public class MathOperations {

    //Факториал числа
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не определён для отрицательных чисел");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    //Площадь треугольника
    public static double triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными числами");
        }
        return (base * height) / 2;
    }

    //Арифметические операции
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль недопустимо");
        }
        return (double) a / b;
    }

    //Сравнение
    public static String compare(int a, int b) {
        if (a > b) {
            return a + " > " + b;
        }
        else if ( a < b) {
            return a + " < " + b;
        }
        else {
            return a + " = " + b;
        }
    }
}
