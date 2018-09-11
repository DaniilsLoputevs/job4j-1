package ru.job4j.chess.firuges.exeptions;

public class FigureNotFoundException extends Exception {

    public FigureNotFoundException() {
        super("Не найдена фигура");

    }
}
