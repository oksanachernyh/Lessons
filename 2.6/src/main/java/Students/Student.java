package Students;

import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map < String, Integer > grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void promoteToNextCourse() {
        this.course++;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Студент: " + name +
                ", Группа: " + group +
                ", Курс: " + course +
                ", Средний балл: " + String.format("%.2f",calculateAverageGrade());
    }
}
