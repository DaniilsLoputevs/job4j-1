package ru.job4j.chess.firuges.exeptions;

public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
        super("Путь занят");

    }
}
