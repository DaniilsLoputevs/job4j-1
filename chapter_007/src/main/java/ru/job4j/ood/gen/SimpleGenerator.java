package ru.job4j.ood.gen;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Generator {
    private final Pattern pattern;
    private Map<String, String> map;

    public SimpleGenerator(Pattern pattern, Map<String, String> map) {
        this.pattern = pattern;
        this.map = map;
    }

    /**
     * Метод принимающий строку с ключами , которые впоследствии требуется заменить на значения из Map
     * Используется метод класса String replace();
     *
     * @param template Входящая строка с данными и ключами
     * @return Измененная строка.
     */
    @Override
    public String generate(String template) {
        Matcher matcher = pattern.matcher(template);
        String tmp = template;
        while (matcher.find()) {
            tmp = tmp.replace(matcher.group(), checkvalues(matcher.group()));
        }
        checkExtraKeys();
        return tmp;
    }

    /**
     * Метод возвращает значение по ключу из Map, если ключ не найден кидается исключение
     * IllegalStateException
     *
     * @param key ключ
     * @return Значение из карты
     */
    private String checkvalues(String key) {
        String rs = map.remove(key);
        if (Objects.isNull(rs)) {
            throw new IllegalStateException("keys not found");
        }
        return rs;
    }

    /**
     * Метод проверяет на соответствие количества ключей в карте .
     * Бросет исключение в случае обнаружения лишних ключей.
     */
    private void checkExtraKeys() {
        if (map.size() != 0) {
            throw new IllegalStateException("extra keys available");
        }
    }

    /**
     * "I am a ${name}, Who are ${subject}? "
     *
     * @param args
     */
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\$\\{\\w+\\})");
        Matcher matcher = pattern.matcher("I am a ${name}, Who are ${subject}?");
        System.out.println(matcher.find());
        Map<String, String> map = new HashMap<>();
        map.put("${name}", "Vik");
        map.put("${subject}", "you");

        SimpleGenerator simpleGenerator = new SimpleGenerator(pattern, map);
        System.out.println(simpleGenerator.generate("I am a ${name}, Who are ${subject}?"));

    }
}
