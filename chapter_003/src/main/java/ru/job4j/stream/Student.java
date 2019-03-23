package ru.job4j.stream;


import java.util.Comparator;
import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0, 1
 * @since 13.03.2019
 */
public class Student implements Comparator<Student> {
    private int score;
    private String lastName;

    public Student(int score, String lastName) {
        this.score = score;
        this.lastName = lastName;
    }

    public Student(int score) {
        this.score = score;
    }


    public String getLastName() {
        return lastName;
    }


    public int getScore() {
        return score;
    }


    @Override
    public String toString() {
        return "Student{"
                +
                "score="
                + score
                +
                '}';
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getScore() - o2.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getScore() == student.getScore()
                &&
                getLastName().equals(student.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore(), getLastName());
    }
}
