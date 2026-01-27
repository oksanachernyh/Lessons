package Error;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Ошибка размера!Массив должен быть 4х4");
    }
    public MyArraySizeException(String message) {
        super(message);
    }
}

