package Error;

public class MyArrayDateException extends Exception{
    private int row;
    private int col;
    private String value;

    public MyArrayDateException (int row, int col, String value) {
        super("Ошибка в ячейке [" + row + "][" + col + "]: '" + value + "' не число!");
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
