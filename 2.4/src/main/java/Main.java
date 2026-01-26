public class Main {
    public static void main(String[] args) {
        System.out.println("\n==== Задание 1: Животные ====");
        System.out.println("\n=== Животные бегают и плавают ===");

        Dog dog1 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурка");

        System.out.println("\nБег");
        dog1.run(300);
        dog1.run(600);
        cat1.run(150);
        cat1.run(250);

        System.out.println("\nПлавание");
        dog1.swim(5);
        dog1.swim(15);
        cat1.swim(5);

        System.out.println("\n=== Кошки едят ===");

        Bowl bowl = new Bowl(-5);
        System.out.println("Создана миска с едой: " + bowl.food + " еды");

        bowl.addFood(20);

        Cat [] cats = new Cat[3];
        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Персик");
        cats[2] = new Cat("Милка");

        System.out.println("\nКормим котов: ");
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl);
            System.out.println("В миске осталось: " + bowl.food);
            System.out.println(" ");
        }

        System.out.println("\nСытость котов: ");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isFull ? "сыт" : "голоден"));
        }

        System.out.println("\n=== Докармливание ===");
        bowl.addFood(30);

        for (Cat cat : cats) {
            if (!cat.isFull) {
                cat.eatFromBowl(bowl);
            }
        }

        System.out.println("\n=== Статистика ===");
        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Собак: " + Dog.dogCount);
        System.out.println("Кошек: " + Cat.catCount);





        System.out.println("\n\n==== Задание 2: Геометрические фигуры ====");

        Circle circle = new Circle(5, "Красный", "Чёрный");
        Rectangle rectangle = new Rectangle(4, 6, "Синий", "Белый");
        Triangle triangle = new Triangle(3,4,5, "Зелёный", "Жёлтый");

        System.out.println("\n=== Круг ===");
        circle.printInfo();

        System.out.println("\n=== Прямоугольник ===");
        rectangle.printInfo();

        System.out.println("\n=== Треугольник ===");
        triangle.printInfo();

        GeometricFigure [] figures = {circle, rectangle, triangle};

        System.out.println("\n=== Все фигуры ===");
        for (GeometricFigure figure : figures) {
            figure.printInfo();
            System.out.println();
        }

        System.out.println("Фигур создано: " + figures.length);
    }
}
