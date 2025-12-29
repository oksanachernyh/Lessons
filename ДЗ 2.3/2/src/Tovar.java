public class Tovar {
    private String name;
    private String data;
    private String proizvoditel;
    private String strana;
    private String cena;
    private String bron;
    public Tovar (String name, String data, String proizvoditel, String strana, String cena, String bron) {
        this.name = name;
        this.data = data;
        this.proizvoditel = proizvoditel;
        this.strana = strana;
        this.cena = cena;
        this.bron = bron;
    }
    public void info() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + data);
        System.out.println("Производитель: " + proizvoditel);
        System.out.println("Страна происхождения: " + strana);
        System.out.println("Цена: " + cena);
        System.out.println("Состояние бронирования покупателем: " + bron);
    }
    public static void main (String[] args) {
        Tovar[] productsArray = new Tovar[5];
        productsArray[0] = new Tovar("Телевизор", "01.01.2025", "Samsung", "Корея", "100000", "Бронь");
        productsArray[1] = new Tovar("Телефон", "02.02.2025", "Nokia", "Финляндия", "30000", "Свободен");
        productsArray[2] = new Tovar("Ноутбук", "03.03.2025", "Apple", "Америка", "150000", "Бронь");
        productsArray[3] = new Tovar("Телевизор", "04.04.2025", "LG", "Корея", "70000", "Свободен");
        productsArray[4] = new Tovar("Телефон", "05.05.2025", "Samsung", "Корея", "60000", "Бронь");
        for (Tovar t : productsArray) {
            t.info();
        }

    }
}
