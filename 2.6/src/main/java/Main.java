import Guide.PhoneDirectory;
import Students.Student;

import java.util.*;

public class Main {
    public static void removeUnderperformingStudents(List <Student> students) {
        System.out.println("\nУдаление студентов с плохой успеваемостью:");
        Iterator <Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.calculateAverageGrade() < 3.0) {
                System.out.println("Удалён: " + student.getName());
                iterator.remove();
            }
        }
    }

    public static void promoteStudents (List <Student> students) {
        System.out.println("\nПеревод на следующий курс:");

        for (Student student : students) {
            if (student.calculateAverageGrade() >= 3.0) {
                System.out.println(student.getName() + " переведён на " + (student.getCourse() + 1) + " курс");
                student.promoteToNextCourse();
            }
        }
    }

    public static void printStedents (Set <Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентов на " + course + " курсе не найдено");
        }
    }

    private static void searchAndPrint(PhoneDirectory phoneBook, String lastName) {
        List <String> phones = phoneBook.get(lastName);
        if (phones.isEmpty()) {
            System.out.println("Фамилия " + lastName + " не найдена в справочнике");
        }
        else {
            System.out.println("Телефоны для " + lastName + ": " + phones);
        }
    }



    public static void main(String[] args) {
        System.out.println("\n=== Задание 1: Студенты ===\n");

        List <Student> students = new ArrayList<>();

        Student student1 = new Student("Иванов Иван", "ГД-101", 1);
        student1.addGrade("Математика", 4);
        student1.addGrade("Русский язык", 3);
        student1.addGrade("Информатика", 5);

        Student student2 = new Student("Петров Пётр", "ГД-102", 1);
        student2.addGrade("Математика", 2);
        student2.addGrade("Русский язык", 3);
        student2.addGrade("Информатика", 2);

        Student student3 = new Student("Козлова Ольга", "ГД-102", 1);
        student3.addGrade("Математика", 5);
        student3.addGrade("Русский язык", 5);
        student3.addGrade("Информатика", 5);

        Student student4 = new Student("Смирнова Алёна", "ГД-201", 2);
        student4.addGrade("Математика", 5);
        student4.addGrade("Русский язык", 4);
        student4.addGrade("Информатика", 5);

        Student student5 = new Student("Кабанов Максим", "ГД-202", 2);
        student5.addGrade("Математика", 3);
        student5.addGrade("Русский язык", 3);
        student5.addGrade("Информатика", 2);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        System.out.println("Все студенты:");
        for (Student student : students) {
            System.out.println(student);
        }

        removeUnderperformingStudents(students);

        promoteStudents(students);

        Set <Student> studentSet = new HashSet<>(students);

        printStedents(studentSet, 1);
        printStedents(studentSet, 2);
        printStedents(studentSet, 3);
        printStedents(studentSet,4);

        System.out.println("\n\n=== Задание 2: Телефонный справочник ===");

        PhoneDirectory phoneBook = new PhoneDirectory();

        phoneBook.add("Иванов", "+7-111-111-11-11");
        phoneBook.add("Петров", "+7-222-222-22-22");
        phoneBook.add("Сидорова", "+7-333-333-33-33");
        phoneBook.add("Иванов", "+7-444-444-44-44");
        phoneBook.add("Иванов", "+7-555-555-55-55");

        phoneBook.printAll();

        System.out.println("\nПоиск телефонов:");
        searchAndPrint(phoneBook, "Иванов");
        searchAndPrint(phoneBook, "Петров");
        searchAndPrint(phoneBook, "Сидорова");
        searchAndPrint(phoneBook, "Козлова");
    }
}
