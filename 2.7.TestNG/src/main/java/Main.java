public class Main {
    public static void main(String[] args) {

        System.out.println("\n=== Факториал числа ===");
        System.out.println("Факториал 5: " + MathOperations.factorial(5));
        System.out.println("Факториал 0: " + MathOperations.factorial(0));

        System.out.println("\n=== Площадь треугольника ===");
        System.out.println("Если основание треугольника = 10, а высота = 5, то площадь = " + MathOperations.triangle(10,5));

        System.out.println("\n=== Арифметические операции ===");
        int x = 10, y = 5;
        System.out.println(x + " + " + y + " = " + MathOperations.add(x,y));
        System.out.println(x + " - " + y + " = " + MathOperations.subtract(x,y));
        System.out.println(x + " * " + y + " = " + MathOperations.multiply(x,y));
        System.out.println(x + " / " + y + " = " + MathOperations.divide(x,y));

        System.out.println("\n=== Сравнение чисел ===");
        System.out.println("Сравнение 10 и 5: " + MathOperations.compare(10, 5));
        System.out.println("Сравнение 5 и 10: " + MathOperations.compare(5, 10));
        System.out.println("Сравнение 7 и 7: " + MathOperations.compare(7, 7));
    }
}
