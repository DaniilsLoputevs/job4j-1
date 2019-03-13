package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SchoolTest {

    @Test
    public void aClass() {
        School school = new School();

        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new Student(i * 10));
        }
        List<Student> aClass = school.collect(students, predicate -> predicate.getScore() >= 70 && predicate.getScore() <= 100);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70));
        expected.add(new Student(80));
        expected.add(new Student(90));
        expected.add(new Student(100));
        assertThat(aClass, is(expected));
    }

    @Test
    public void bClass() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new Student(i * 10));
        }
        List<Student> bClass = school.collect(students, predicate -> predicate.getScore() >= 50 && predicate.getScore() <= 70);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50));
        expected.add(new Student(60));
        expected.add(new Student(70));
        assertThat(bClass, is(expected));
    }

    @Test
    public void cClass() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            students.add(new Student(i * 10));
        }
        List<Student> cClass = school.collect(students, predicate -> predicate.getScore() >= 0 && predicate.getScore() <= 50);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(0));
        expected.add(new Student(10));
        expected.add(new Student(20));
        expected.add(new Student(30));
        expected.add(new Student(40));
        expected.add(new Student(50));
        assertThat(cClass, is(expected));
    }
}