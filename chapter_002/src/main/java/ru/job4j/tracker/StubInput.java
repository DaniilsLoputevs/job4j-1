package ru.job4j.tracker;

public class StubInput implements Input {
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
}
