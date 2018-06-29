package ru.job4j.dop;

public class Merger {

    public int[] merger(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int i = 0;
        while (i < result.length) {
            if (firstIndex == a.length) {
                result[i] = b[secondIndex++];
            } else if (secondIndex == b.length) {
                result[i] = a[firstIndex++];
            } else {
                result[i] = a[firstIndex] < b[secondIndex] ? a[firstIndex++] : b[secondIndex++];
            }


            i++;
        }

        return result;
    }

}


