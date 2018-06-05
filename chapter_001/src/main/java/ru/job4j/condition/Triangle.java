package ru.job4j.condition;

/**
 * Package for condition task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
  public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    private boolean exist(double ab, double ac, double bc) {
/**
 * Проверка на условие : сумма двух сторон должна быть больше третьей стороны .
 */

        return ((ab + bc) > ac) && ((bc + ac) > ab) && ((ac + ab) > bc);
        }
    }



