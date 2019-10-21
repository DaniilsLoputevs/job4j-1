package ru.job4j.ood.gen;

import java.util.List;

public interface Generator {

    String generate(String template, List<String> val);
}
