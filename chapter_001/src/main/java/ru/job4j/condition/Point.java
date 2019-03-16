package ru.job4j.condition;

public class Point {
    /**
     * Обьявим данные в поле.
     */
    private int x;
    private int y;

    /**
     * Конструктор.
     *
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод для расчета дистанции между точками и математические операциии из класса Math
     * 1. Math.sqrt =  квадратный корень.
     * 2.Math.pow = (a,b) где а= число возводимое в степерь b.
     *
     * @param that
     * @return
     */
    public double distanceTo(Point that) {

        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

}
