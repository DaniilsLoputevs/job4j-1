package ru.job4j.stream;

import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0, 1
 * @since 13.03.2019
 */
public class Student {
    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    private int score;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getScore() == student.getScore();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore());
    }

    public void setScore(int score) {
        this.score = score;
    }
}
