package ru.job4j.chess.firuges.black;


import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposibleMoveExeptions;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Реализация интерфейса Figure
     *
     * @param source началььная точка.
     * @param dest   точка назначения.
     * @return движение фигуры.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveExeptions {
        Cell[] move;
        if (!isDiagonal(source, dest)) {
            throw new ImposibleMoveExeptions("Данная фигура не может ходить.");
        } else {
            move = new Cell[]{dest};
        }

        return move;
    }


    @Override

    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }


}
