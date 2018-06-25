package ru.job4j.dop;

public class Merger {

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int i = 0;

        while (i < result.length) {
            result[i] = a[firstIndex] < b[secondIndex] ? a[firstIndex++] : b[secondIndex++];
            if (firstIndex == a.length) {
                System.arraycopy(b, secondIndex, result, ++i, b.length - secondIndex);
                break;
            }
            if (secondIndex == b.length) {
                System.arraycopy(a, firstIndex, result, ++i, a.length - firstIndex);
                break;
            }
            i++;
        }
        return result;
    }
}



