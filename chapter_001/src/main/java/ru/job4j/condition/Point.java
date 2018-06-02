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

    /**
     * Метод main
     *
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(10, 45);
        Point b = new Point(15, 56);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
