public class Main {
    public static void main(String[] args) {
        System.out.println(checkSum(9, 8));
    }

    public static boolean checkSum(int num1, int num2) {
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }
}