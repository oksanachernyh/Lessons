public class Main {
    public static void checkNumber(int num) {
        if (num >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static void main(String[] args) {
        checkNumber(5);
    }
}