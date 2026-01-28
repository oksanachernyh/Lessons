package Guide;

import java.util.*;

public class PhoneDirectory {
    private Map <String, List <String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        directory.putIfAbsent(lastName, new ArrayList<>());
        directory.get(lastName).add(phoneNumber);
    }

    public List <String> get(String lastName) {
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    public void printAll() {
        System.out.println("\nТелефонный справочник:");
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
