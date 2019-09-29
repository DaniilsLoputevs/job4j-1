package ru.job4j.ood.calc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserActionsTest {

    @Test(expected = NumberFormatException.class)
    public void addActionsAndParseToDouble() {
        UserActions userActions = new UserActions();
        userActions.addActions("d");
        assertThat(userActions.addActions("1"), is(1.0));
        assertThat(userActions.addActions("999"), is(999.0));

    }

    @Test
    public void isReadyFalseAfterAddTwoValue() {
        UserActions userActions = new UserActions();
        userActions.addActions("2");
        userActions.addActions("3");
        assertThat(userActions.isReady(), is(false));
    }

    @Test
    public void isReadyReturnTrue() {
        UserActions userActions = new UserActions();
        userActions.addActions("1");
        assertThat(userActions.isReady(), is(true));
    }
}