package Animals;

public class Animal {                    //Животное
    public String name;
    public static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал(а) " + distance + " м.");
    }

    public void swim(int distancе) {
        System.out.println(name + " проплыл(а) " + distancе + " м.");
    }
}