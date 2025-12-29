import java.util.ArrayList;
public class Park {
    private ArrayList<Attraction> attractions;
    public Park() {
        attractions = new ArrayList<>();
    }
    public class Attraction {
        private String name;
        private String workingHours;
        private double price;
        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getWorkingHours() {
            return workingHours;
        }
        public void setWorkingHours(String workingHours) {
            this.workingHours = workingHours;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        @Override
        public String toString() {
            return "Аттракцион: " + name + ", Время работы: " + workingHours + ", Стоимость: " + price;
        }
    }
    public void addAttraction(String name, String workingHours, double price) {
        attractions.add(new Attraction(name, workingHours, price));
    }
    public void printAttractions() {
        for (Attraction attraction : attractions) {
            System.out.println(attraction);
        }
    }
    public static void main(String[] args) {
        Park park = new Park();
        park.addAttraction("Американские горки", "09:00 - 21:00", 500);
        park.addAttraction("Карусель", "10:00 - 22:00", 300);
        park.addAttraction("Батут", "11:00 - 20:00", 200);
        park.printAttractions();
    }
}
