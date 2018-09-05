package chess;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class BishopTest {

     private Logic logic = new Logic();

    @Test
    public void whenBishopMoveRight()  {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F2));
        assertThat(logic.move(Cell.F2, Cell.B6), is(true));

    }

    @Test
    public void whenBishopBlackCanNotMove()  {
        logic.add(new BishopBlack(Cell.F8));
        assertThat(logic.move(Cell.F8, Cell.B1), is(false));
    }
}
