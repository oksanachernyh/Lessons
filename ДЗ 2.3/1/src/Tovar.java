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
        Tovar tovar = new Tovar(
                "Телефон", "26.12.25", "Samsung", "Южная Корея", "65000", "Забронировано"
        );
        tovar.info();
    }
}
