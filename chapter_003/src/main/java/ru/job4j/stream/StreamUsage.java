package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 10.03.2019
 */
public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    +
                    "name='"
                    + name
                    + '\''
                    +
                    ", spent="
                    + spent
                    +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        /**
         * 1.Фильтрация
         * Рассмотрим детали
         * task.stream() получаем обьект типа Stream
         * filter - принимает лямбда выражение Predicate<Task>
         *  условие , пропуск тех задач который содержат "Bug"
         *  .collect(Collectors.toList()) - полученный результат сохранить в коллекции типа List
         *
         */
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        /**
         * 2.Преобразование
         * Нужно получить только имена задач. Для этого нужно применить метод map
         *
         */

        List<String> name = tasks.stream().map(task -> task.name).collect(Collectors.toList());

        /**
         * 3.Упрощение
         * .reduce(0L,Long::sum)- каждое значение task.spent - нужно сложить с начальным значением 0L.
         * результат общее время потраченное на все залачи.
         */
        long total = tasks.stream().map(task -> task.spent).reduce(0L, Long::sum);
    }
}


