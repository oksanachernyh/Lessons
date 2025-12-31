import java.util.*;
public class PhoneDirectory {
    private Map<String, List<String>> directory;
    public PhoneDirectory() {
        directory = new HashMap<>();
    }
    public void add(String lastName, String phoneNumber) {
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }
    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, Collections.emptyList());
    }
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        directory.add("Иванов", "123-45-67");
        directory.add("Иванов", "987-65-43");
        directory.add("Петров", "555-55-55");
        String searchLastName = "Иванов";
        List<String> numbers = directory.get(searchLastName);
        if (!numbers.isEmpty()) {
            System.out.println("Телефоны для " + searchLastName + ":");
            for (String number : numbers) {
                System.out.println(number);
            }
        } else {
            System.out.println("Записи для " + searchLastName + " не найдены.");
        }
    }
}
