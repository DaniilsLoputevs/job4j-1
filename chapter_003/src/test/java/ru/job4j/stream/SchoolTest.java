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
        students.add(new Student(70, "A"));
        students.add(new Student(90, "B"));
        students.add(new Student(100, "C"));
        students.add(new Student(60, "D"));

        List<Student> aClass = school.collect(students, predicate -> predicate.getScore() >= 70 && predicate.getScore() <= 100);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "A"));
        expected.add(new Student(90, "B"));
        expected.add(new Student(100, "C"));
        assertThat(aClass, is(expected));
    }

    @Test
    public void bClass() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(40, "A"));
        students.add(new Student(50, "B"));
        students.add(new Student(60, "C"));
        students.add(new Student(70, "D"));
        List<Student> bClass = school.collect(students, predicate -> predicate.getScore() >= 50 && predicate.getScore() <= 70);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "B"));
        expected.add(new Student(60, "C"));
        expected.add(new Student(70, "D"));
        assertThat(bClass, is(expected));
    }

    @Test
    public void cClass() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student student = new Student(0, "A");
        Student student2 = new Student(50, "B");
        Student student3 = new Student(40, "C");
        Student student4 = new Student(30, "D");
        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        List<Student> cClass = school.collect(students, predicate -> predicate.getScore() >= 0 && predicate.getScore() <= 50);
        List<Student> expected = new ArrayList<>();
        expected.add(student);
        expected.add(student2);
        expected.add(student3);
        expected.add(student4);
        assertThat(cClass, is(expected));
    }

    @Test
    public void levelOf() {
        List<Student> students = List.of(
                new Student(100, "V"),
                new Student(60, "B"),
                new Student(35, "Z")
        );
        School school = new School();
        List<Student> expected = List.of(
                new Student(100, "V"),
                new Student(60, "B")
        );
        List<Student> result = school.levelOf(students, 50);
        assertThat(result, is(expected));
    }
}