package ru.job4j.dop;

public class Section {


    public boolean sect(int a, int b, int c, int d) {
        boolean cross = false;
        if ((c <= a && a <= d) || (a <= c && c <= b)) {
            cross = true;
        }
        return cross;
    }
}