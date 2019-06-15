package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class AnalizyTest {
    public Analizy analizy;
    public StringBuilder stringBuilder;
    public StringJoiner stringJoiner;

    @Before
    public void init() {
        analizy = new Analizy();
        stringBuilder = new StringBuilder("400 10:58:01").append(System.lineSeparator())
                .append("200 10:59:01").append(System.lineSeparator())
                .append("500 11:01:02").append(System.lineSeparator())
                .append("200 11:02:02");

        stringJoiner = new StringJoiner(System.lineSeparator());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("unavailable.csv"))) {
            bufferedReader.lines().forEach(stringJoiner::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void unavailable() {
        analizy.unavailable("serverlog.txt", "unavailable.csv");
        assertEquals(stringBuilder.toString(), stringJoiner.toString());


    }

}
