public class Main {
    public static boolean isYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isYear(2024));
    }
}