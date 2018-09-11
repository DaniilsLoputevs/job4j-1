package chess;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.exeptions.FigureNotFoundException;
import ru.job4j.chess.firuges.exeptions.ImposibleMoveExeptions;
import ru.job4j.chess.firuges.exeptions.OccupiedWayException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты на поведение фигуры Bishop Black.
 *
 * @author Sergey Bolshanin
 * @version 1.0
 * @since 11.09.2018
 */

public class BishopTest {

    /**
     * Проверка правильности ходов Слона .
     *
     * @throws OccupiedWayException    = путь занят.
     * @throws FigureNotFoundException = фигура не найдена.
     * @throws ImposibleMoveExeptions  = фигура не может так ходить.
     */
    @Test
    public void whenBishopMoveRight() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeptions {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F2));
        assertThat(logic.move(Cell.F2, Cell.B6), is(true));

    }

    /**
     * Тест на проверку невозможности хода фигуры .
     *
     * @throws OccupiedWayException    = путь занят
     * @throws FigureNotFoundException = фигура не найдена
     * @throws ImposibleMoveExeptions  = фигура не может так ходить.
     */
    @Test(expected = ImposibleMoveExeptions.class)
    public void whenBishopBlackCanNotMove() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeptions {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F1));
        assertThat(logic.move(Cell.F1, Cell.B1), is(false));
    }

    /**
     * Тест на полный путь фигуры по координатам шахматной доски.
     *
     * @throws OccupiedWayException    = путь занят
     * @throws FigureNotFoundException = фигура не найдена
     * @throws ImposibleMoveExeptions  = фигура не может так ходить.
     */
    @Test
    public void whenBishopMoveInDiagonal() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeptions {
        BishopBlack bishop = new BishopBlack(Cell.F1);
        Cell[] way = bishop.way(bishop.position(), Cell.B5);
        Cell[] expected = {Cell.E2, Cell.D3, Cell.C4, Cell.B5};
        assertThat(way, is(expected));
    }
}
