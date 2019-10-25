package ru.job4j.concurrency;


import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;

    }

    /**
     * Метод запускает кубик в правую сторону и при достижении границы отправляется в левую сторону
     * step служит шагом для движения кубика по полю , если он достигает правой границы , умножаем на -1 и получаем отрицательное движение.
     * при достижении координаты 0 умножаем переменную шага на -1 , что дает положительное число и движение возобновляется в правую сторону.
     */
    @Override
    public void run() {
        int step = 2;
        while (!Thread.currentThread().isInterrupted()) {
            if (PingPong.X >= this.rect.getX()) {
                step *= -1;
            }
            if (0 <= this.rect.getX()) {
                step *= -1;
            }
            this.rect.setX(this.rect.getX() + step);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }

    }


}


