public class Main {
    public static void main(String[] args) {
        int[] array = createArray(3, 6);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}