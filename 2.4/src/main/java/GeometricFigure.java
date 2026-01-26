public interface GeometricFigure {                 //Интерфейс
    double area();
    double perimeter();
    String fillColor();
    String borderColor();

    default void printInfo(){
        System.out.println("Площадь: " + area());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Цвет заливки: " + fillColor());
        System.out.println("Цвет границ: " + borderColor());
    }
}
