package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void collect() {
        CollectToMap collectToMap = new CollectToMap();
        List<Student> students = new ArrayList<>();
        Student student = new Student(45, "Ivanov");
        Student student2 = new Student(45, "Petrov");
        students.add(student);
        students.add(student2);
        Map<String, Student> expected = new HashMap<>();
        expected.put(student.getLastName(), student);
        expected.put(student2.getLastName(), student2);
        assertThat(collectToMap.collect(students), is(expected));


    }
}