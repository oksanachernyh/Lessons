public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        dog1.run(300);
        dog1.swim(5);
        dog2.run(600);
        dog2.swim(15);
        cat1.run(150);
        cat1.swim(5);
        cat2.run(250);
        MilkBowl bowl = new MilkBowl(10);
        Cat[] cats = {cat1, cat2};
        for (Cat cat : cats) {
            cat.eat(bowl, 5);
        }
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сытый: " + cats[i].isSatiety());
        }
        bowl.addFood(20);
        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                cat.eat(bowl, 10);
            }
        }
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сытый: " + cats[i].isSatiety());
        }
        System.out.println("Общее количество животных: " + Animal.animalCount);
        System.out.println("Количество котов: " + Animal.catCount);
        System.out.println("Количество собак: " + Animal.dogCount);
    }
}
class Animal {
    static int animalCount = 0;
    static int dogCount = 0;
    static int catCount = 0;
    public Animal() {
        animalCount++;
    }
    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }
    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }
}
class Dog extends Animal {
    private static final int MAX_RUN = 500;
    private static final int MAX_SWIM = 10;
    public Dog() {
        super();
        dogCount++;
    }
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println("Пес пробежал " + distance + " м.");
        } else {
            System.out.println("Пес не может пробежать так далеко.");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM) {
            System.out.println("Пес проплыл " + distance + " м.");
        } else {
            System.out.println("Пес не может проплыть так далеко.");
        }
    }
}
class Cat extends Animal {
    private static final int MAX_RUN = 200;
    private static final int MAX_SWIM = 0;
    private boolean satiety;
    private boolean hungry;
    public Cat() {
        super();
        catCount++;
        this.hungry = true;
        this.satiety = false;
    }
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать так далеко.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать.");
    }
    public void eat(MilkBowl bowl, int foodAmount) {
        if (foodAmount <= 0) {
            System.out.println("Некорректное количество еды.");
            return;
        }
        if (bowl.getFood() >= foodAmount) {
            boolean success = bowl.takeFood(foodAmount);
            if (success) {
                this.satiety = true;
                this.hungry = false;
                System.out.println("Кот покушал. Осталось еды в миске: " + bowl.getFood());
            } else {
                System.out.println("Недостаточно еды в миске.");
            }
        } else {
            System.out.println("В миске недостаточно еды для этого кота.");
        }
    }
    public boolean isSatiety() {
        return satiety;
    }
}
class MilkBowl {
    private int food;
    public MilkBowl(int initialFood) {
        this.food = initialFood;
    }
    public int getFood() {
        return food;
    }
    public boolean takeFood(int amount) {
        if (amount <= food) {
            food -= amount;
            return true;
        }
        return false;
    }
    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено еды: " + amount + ". Общее количество: " + food);
        }
    }
}