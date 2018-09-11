package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exeptions.FigureNotFoundException;
import ru.job4j.chess.firuges.exeptions.ImposibleMoveExeptions;
import ru.job4j.chess.firuges.exeptions.OccupiedWayException;




/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImposibleMoveExeptions, OccupiedWayException {
        int index = this.findBy(source);
        Cell[] steps = this.figures[index].way(source, dest);
        checkOcupied(steps);
        boolean rst = false;
        if (steps.length > 0) {
            this.figures[index] = this.figures[index].copy(dest);
            rst = true;
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }

        }
        if (rst == -1) {
            throw new FigureNotFoundException();
        }
        return rst;
    }

    public void checkOcupied(Cell[] steps) throws OccupiedWayException {
        boolean res = true;
        for (int i = 0; i < steps.length; i++) {
            for (int l = 0; l < figures.length; l++) {
                if (figures[l] != null && steps[i].equals(figures[l].position())) {
                    res = false;
                    break;
                }
            }
        }
        if (!res) {
            throw new OccupiedWayException();
        }
    }


}
