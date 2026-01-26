public class Cat extends Animal {          //Кошка
    static int catCount = 0;
    boolean isFull = false;
    int appetite = 10;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distancе) {
        if (distancе <= 200) {
            System.out.println(name + " пробежал(а) " + distancе + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distancе + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кошки не умееют плавать!");
    }

    public void eatFromBowl(Bowl bowl) {
        if (isFull) {
            System.out.println(name + " сыт(а)!");
            return;
        }
        if (bowl.food >= appetite) {
            bowl.food -= appetite;
            isFull = true;
            System.out.println(name + " поел(а).");
        } else {
            System.out.println(name + " не может поесть!");
        }
    }
}