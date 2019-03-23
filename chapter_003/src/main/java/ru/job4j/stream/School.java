package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 13.03.2019
 */
public class School {
    /**
     * Метод выводит список с некоторым условием
     * @param students список студентов
     * @param predicate функц интерфейс
     * @return итоговый результат
     */

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }
    /**
     * Метод возвращениея List по определенному условию
     * @param students список студентов.
     * @param bound переменная определяющее условие попадение данных в итоговую структуру.
     * @return результирующий список составленный с помощью StreamAPI
     */

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(Comparator.comparing(Student::getScore).reversed()).distinct().flatMap(Stream::ofNullable).takeWhile(student -> student.getScore() >= bound).collect(Collectors.toList());
    }

}