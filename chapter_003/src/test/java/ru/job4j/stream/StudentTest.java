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
        students.add(new Student(45, "Ivanov"));
        students.add(new Student(46, "Petrov"));
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student(45));
        expected.put("Petrov", new Student(46));
        assertThat(collectToMap.collect(students), is(expected));


    }
}