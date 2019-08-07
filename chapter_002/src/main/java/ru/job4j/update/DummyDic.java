package ru.job4j.update;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 05.08.2019
 */
public class DummyDic {

    public String engtorus(String eng) {
        String s = "Неизвестное слово: ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s).append(eng);
        return stringBuilder.toString();
    }
}
