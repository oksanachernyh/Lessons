package Error;

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDateException {
        if (array.length != 4) {
            throw new MyArraySizeException("Строк должно быть 4, а не " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("В строке " + i + " должно быть 4 элемента, а не " + array[i].length);
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDateException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void demonstrateIndexError() {
        int[] num = {1, 2, 3, 4, 5};

        try {
            int x = num[10];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймана ошибка!");
            System.out.println("Сообщение: "+ e.getMessage());
        }
    }
}

