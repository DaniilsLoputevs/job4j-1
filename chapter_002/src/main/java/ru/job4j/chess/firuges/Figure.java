package ru.job4j.chess.firuges;

import ru.job4j.chess.firuges.exeptions.ImposibleMoveExeptions;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest) throws ImposibleMoveExeptions;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
