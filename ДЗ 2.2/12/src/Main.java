public class Main {
    public static void main (String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("arr.length: " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}