package ru.job4j.dop;

public class MergerTwo {

    public static int[] mergertwo(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int i = 0;

        while (i < result.length) {
            result[i] = a[firstIndex] < b[secondIndex] ? a[firstIndex++] : b[secondIndex++];
            if (firstIndex == a.length) {
                for (int z = secondIndex; z < b.length; z++) {
                    i++;
                    result[i] = b[z];
                }

                break;
            }
            if (secondIndex == b.length) {
                for (int y = firstIndex; y < a.length; y++) {
                    i++;
                    result[i] = b[y];
                }

                break;
            }
            i++;
        }
        return result;
    }
}
