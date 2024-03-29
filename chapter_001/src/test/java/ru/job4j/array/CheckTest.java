package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataNotSecMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataNotSecTwoMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    @Test
 	 	public void whenDataNotMentorSecTwoMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
         }
}

