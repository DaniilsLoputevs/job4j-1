package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 27.02.2019
 */
public class Functional {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i != end; i++) {
            result.add(func.apply((double) i));

        }
        return result;
    }
}
