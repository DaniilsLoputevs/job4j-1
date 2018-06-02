package ru.job4j.calculate;
import org.junit.Test;
import ru.job4j.max.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Package for max| task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {
    /**
     *
     * Реализация тестирования где firts<second.
     */
    @Test
        public void whenFirstLessSecond() {
        Max maximless = new Max();
        int result = maximless.max(15, 45);
        assertThat(result, is(15));
    }




}
