package ru.job4j.dop;

public class IsSorted {
    public boolean checksort(int[] array) {
        boolean sort = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sort = false;
                break;

            }
        }
        return sort;
    }
}
