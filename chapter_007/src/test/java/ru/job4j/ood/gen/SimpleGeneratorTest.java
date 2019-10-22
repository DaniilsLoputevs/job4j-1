package ru.job4j.ood.gen;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {

    @Test
    public void generateStringAfterReplace() {
        Pattern pattern = Pattern.compile("(\\$\\{\\w+\\})");
        Map<String, String> map = new HashMap<>();
        map.put("${name}", "Value");
        map.put("${subject}", "you");
        SimpleGenerator simpleGenerator = new SimpleGenerator(pattern, map);
        assertThat(simpleGenerator.generate("${name}, ${subject}"), is("Value, you"));
    }
}