package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

import ru.job4j.condition.Point;
import ru.job4j.condition.Triangle;
public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(20, 10);
        Point b = new Point(0, 20);
        Point c = new Point(20, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 1D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 100));
    }
}