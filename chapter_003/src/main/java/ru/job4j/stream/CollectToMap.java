package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1
 * @since 19.03.2019
 */
public class CollectToMap {
    /**
     * Метод пребразует List в Map
     *
     * @param studentList List обьектов класса Student
     * @return Map - где ключ фамилия , значение обьект класса Student.
     */
    public Map<String, Student> collect(List<Student> studentList) {
        Map<String, Student> rs = studentList.stream().distinct().collect(Collectors.toMap((s) -> s.getLastName(), (s) -> s));
        return rs;
    }
}
