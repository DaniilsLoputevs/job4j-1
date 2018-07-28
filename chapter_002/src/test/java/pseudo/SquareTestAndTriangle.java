package pseudo;

import org.junit.Test;
import ru.job4j.pseudo.Square;
import ru.job4j.pseudo.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SquareTestAndTriangle {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                .append("+++++")
                .append(System.lineSeparator())
                .append("+++++")
                .append(System.lineSeparator())
                .append("+++++")
                .toString()));
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                .append("*")
                .append(System.lineSeparator())
                .append("**")
                .append(System.lineSeparator())
                .append("***")
                .append(System.lineSeparator())
                .append("****")
                .toString()));
    }
}
