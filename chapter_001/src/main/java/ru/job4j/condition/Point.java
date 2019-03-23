package ru.job4j.condition;

public class Point {
    private int x;
    private int y;
    /**
     * Конструктор.
     *
     * @param x координата
     * @param y координата
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
     * @param that входящий обьект точки
     * @return Результат расчета расстояния
     */
    public double distanceTo(Point that) {

        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

}
