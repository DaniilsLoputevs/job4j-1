package ru.job4j.dop;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SectionTest {
    @Test
    public void whenTwoSectionCross() {
        Section sect = new Section();
        boolean result = sect.sect(10, 20, 15, 40);
        assertThat(result, is(true));

    }
    @Test
    public void whenTwoSectionNotCross() {
        Section sect = new Section();
        boolean result = sect.sect(27, 28, 30, 35);
        assertThat(result, is(false));
    }
}
