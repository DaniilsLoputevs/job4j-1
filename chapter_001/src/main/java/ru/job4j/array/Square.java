package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[]rst = new int[bound];
        for (int index = 0; index <= bound; index++) {
            if (index == 1) {
                rst[0] = (int) Math.pow(index, 2);
            }
            if (index == 2) {
                rst[1] = (int) Math.pow(index, 2);
            }
            if (index == 3) {
                rst[2] = (int) Math.pow(index, 2);

            }
            if (index == 4) {
                rst[3] = (int) Math.pow(index, 2);
            }
            if (index == 5) {
                rst[4] = (int) Math.pow(index, 2);
            }

        } return rst;
    }
}
