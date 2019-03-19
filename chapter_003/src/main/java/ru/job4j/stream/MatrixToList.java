package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 19.03.2019
 */
public class MatrixToList {

    /**
     * Преобразование матрцы Integer в List<Integer>
     * @param input матрица Integer
     * @return List<Integer>
     */
    public List<Integer> toList(Integer[][] input) {
        List<Integer> rs = Arrays.stream(input).flatMap((i) -> Arrays.stream(i)).collect(Collectors.toList());
        return rs;
    }
}
