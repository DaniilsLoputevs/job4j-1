package ru.job4j.tracker;

import java.util.List;

public class StubInput extends ConsoleInput {
    /**
     * Поле содержащее последовательность ответа пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] value;
    /**
     * Поле считает колличество вызовов метода ask.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[position++];
    }

    @Override

    public int ask(String question, List<Integer> range) {
        int res = Integer.valueOf(this.ask(question));
        return res;

    }

}
