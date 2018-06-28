package ru.job4j.dop;

public class Section {


    public boolean sect(int a, int b, int c, int d) {
        return ((c <= a && a <= d) || (a <= c && c <= b));
    }
}