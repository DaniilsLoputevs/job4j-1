package ru.job4j.condition;

/**
 * Package for condition task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {
    /**
     * Отвечает на вопросы
     *
     * @param question
     * @return Ответ
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        } else if ("Сколько будет 2+2?".equals(question)) {
            rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        }
        return rsl;

    }
}
