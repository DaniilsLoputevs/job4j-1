package ru.job4j.ood;

import org.junit.Test;
import ru.job4j.calculator.Calculator;
import ru.job4j.ood.calculatorood.IterCalc;
import ru.job4j.ood.calculatorood.ScientificCalc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ScientificCalcTest {


    @Test
    public void testAddCalculation() {
        assertThat(this.load().add(10, 10), is(20.0));
        assertThat(this.load().add(5, 2), is(7.0));
    }

    @Test
    public void testSubCalculation() {
        assertThat(this.load().sub(10, 5), is(5.0));
        assertThat(this.load().sub(10, 15), is(-5.0));
    }

    @Test
    public void testMultiplyCalculation() {
        assertThat(this.load().multiply(2, 2), is(4.0));
        assertThat(this.load().multiply(8, 2), is(16.0));
    }

    @Test
    public void testDivCalculation() {
        assertThat(this.load().div(2, 2), is(1.0));
        assertThat(this.load().div(10, 5), is(2.0));
    }

    @Test
    public void sin() {
        assertThat(this.load().sin(5, 8), is(0.625));
    }

    @Test
    public void cos() {
        assertThat(this.load().cos(20, 40), is(0.5));
    }

    @Test
    public void init() {
        assertThat(this.load().getActions().size(), is(6));
    }


    private ScientificCalc load() {
        ScientificCalc s = new ScientificCalc(new IterCalc(new Calculator()));
        s.init();
        return s;
    }
}