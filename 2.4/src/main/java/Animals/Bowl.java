package Animals;

public class Bowl {             //Миска
    public int food;

    public Bowl(int food) {
        if (food < 0) {
            this.food = 0;
            System.out.println("Колличество еды не может быть отрицательным!");
        } else {
            this.food = food;
        }
    }

    public void addFood(int moreFood) {
        if (moreFood > 0) {
            food += moreFood;
            System.out.println("Добавили еды. Теперь: " + food);
        }
    }
}