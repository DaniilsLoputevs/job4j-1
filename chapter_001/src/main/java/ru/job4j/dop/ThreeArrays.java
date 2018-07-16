package ru.job4j.dop;

public class ThreeArrays {
    public int[] mergered(int[] first, int[] second, int[] third) {
        int[] result = new int[first.length + second.length];
        int firstindex = 0;
        int secondindex = 0;
        int thirdindex = 0;
        int i = 0;
        while (i < result.length) {
            if (firstindex == first.length) {
                result[i] = second[secondindex++];
                if (secondindex == second.length) {
                    result[i] = first[firstindex++];
                } else {
                    result[i] = firstindex < secondindex ? firstindex++ : secondindex++;
                }
                }

            }
            i++;
            return result;
        }

    }


