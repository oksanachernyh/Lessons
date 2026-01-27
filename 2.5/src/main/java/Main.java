import Error.ArrayProcessor;
import Error.MyArraySizeException;
import Error.MyArrayDateException;

public class Main {
    public static void main(String[] args)
            throws MyArraySizeException, MyArrayDateException {
        System.out.println("=== Обработка двумерного массива ===\n");
        testCorrectArray();
        testWrongSizeArray();
        testWrongDateArray();
        ArrayProcessor.demonstrateIndexError();
    }

    private static void testCorrectArray() {
        System.out.println("Тест 1: Правильный массив 4х4");

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = ArrayProcessor.processArray(correctArray);
            System.out.println("Сумма = " + result);
        }
        catch (MyArraySizeException | MyArrayDateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testWrongSizeArray() {
        System.out.println("Тест 2: Неправильный размер");

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        try {
            int result = ArrayProcessor.processArray(wrongSizeArray);
            System.out.println("Сумма = " + result);
        }
        catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        }
        catch (MyArrayDateException e) {
            System.out.println("MyArrayDateException: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testWrongDateArray() throws MyArraySizeException, MyArrayDateException {
        System.out.println("Тест 3: Текст вместо числа");

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "шесть", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = ArrayProcessor.processArray(wrongDataArray);
            System.out.println("Сумма = " + result);
        }
        catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        }
        catch (MyArrayDateException e) {
            System.out.println("MyArrayDateException: " + e.getMessage());
        }
        System.out.println();
    }
}
