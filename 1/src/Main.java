import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Иван", "А", 1, Arrays.asList(4.0, 3.5, 4.2)));
        students.add(new Student("Мария", "А", 1, Arrays.asList(2.0, 2.5, 3.0)));
        students.add(new Student("Петр", "А", 1, Arrays.asList(3.0, 3.2, 3.5)));
        students.add(new Student("Елена", "Б", 2, Arrays.asList(4.5, 4.7, 4.8)));
        students.add(new Student("Алексей", "Б", 2, Arrays.asList(2.8, 2.9, 3.0)));
        students.add(new Student("Сергей", "Б", 2, Arrays.asList(4.1, 4.6, 4.3)));
        students.add(new Student("Светлана", "В", 3, Arrays.asList(4.3, 3.9, 4.7)));
        students.add(new Student("Дмитрий", "В", 3, Arrays.asList(3.0, 2.5, 2.2)));
        deleteStudentsWithLowAvg(students);
        promoteStudents(students);
        System.out.println("Студенты 2-го курса:");
        printStudents(students, 2);
        System.out.println("Студенты 3-го курса:");
        printStudents(students, 3);
        System.out.println("Студенты 4-го курса:");
        printStudents(students, 4);
    }
    public static void deleteStudentsWithLowAvg(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.nextCourse();
            }
        }
    }
    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
class Student {
    private String name;
    private String group;
    private int course;
    private List<Double> grades;
    public Student(String name, String group, int course, List<Double> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }
    public String getName() {
        return name;
    }
    public int getCourse() {
        return course;
    }
    public double getAverageGrade() {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
    public void nextCourse() {
        this.course++;
    }
}