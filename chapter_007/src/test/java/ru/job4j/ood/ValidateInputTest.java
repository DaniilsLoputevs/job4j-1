package ru.job4j.ood;

import org.junit.Test;
import ru.job4j.ood.calculatorood.ValidateInput;

import java.util.Set;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {


    @Test
    public void checkInputOperation() {
        assertThat(this.testing().checkInputOperation("+"), is(true));
        assertThat(this.testing().checkInputOperation("*"), is(true));
        assertThat(this.testing().checkInputOperation("-"), is(true));
        assertThat(this.testing().checkInputOperation("/"), is(true));
        assertThat(this.testing().checkInputOperation("0"), is(false));


    }

    @Test
    public void checkInputMemoryUse() {
        assertThat(this.testing().checkInputMemoryUse("m"), is(true));
        assertThat(this.testing().checkInputMemoryUse("M"), is(false));

    }

    @Test
    public void checkExit() {
        assertThat(this.testing().checkExit("exit"), is(true));
        assertThat(this.testing().checkExit("exitt"), is(false));
    }

    private ValidateInput testing() {
        return new ValidateInput(Set.of("+", "-", "*", "/", "m", "exit"));
    }


}