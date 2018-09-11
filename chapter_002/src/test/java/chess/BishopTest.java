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


public class BishopTest {


    @Test
    public void whenBishopMoveRight() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeptions {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F2));
        assertThat(logic.move(Cell.F2, Cell.B6), is(true));

    }

    @Test(expected = ImposibleMoveExeptions.class)
    public void whenBishopBlackCanNotMove() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeptions {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F1));
        assertThat(logic.move(Cell.F1, Cell.B1), is(false));
    }

    @Test
    public void whenBishopMoveInDiagonal() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeptions {
        BishopBlack bishop = new BishopBlack(Cell.F1);
        Cell[] way = bishop.way(bishop.position(), Cell.B5);
        Cell[] expected = {Cell.E2, Cell.D3, Cell.C4, Cell.B5};
        assertThat(way, is(expected));
    }
}
