package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $
 * @since
 */
public class Calculator {
    public interface Operation {
        double calc(int left, int right);
    }


    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public void add(int start, int finish, int value,
                    BiFunction<Integer, Integer, Double> op, Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 50, 5,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },


                result -> System.out.println(result)
        );
        calc.add(0, 100, 10,
                (value, index) -> {
                    double result = value + index;
                    System.out.printf("Add %s + %s = %s %n", value, index, result);
                    return result;
                },
                result-> System.out.println(result)

        );
    }
}
