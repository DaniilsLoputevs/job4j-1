package ru.job4j.io.iochat;

import org.junit.Test;


import java.io.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConsoleChatTest {

    @Test
    public void checkLogFileIsExist() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Привет\nзакончить".getBytes())));
        File file = new File("text");
        PrintStream printWriter = new PrintStream(new FileOutputStream(file));
        ConsoleChat consoleChat = new ConsoleChat(buff, printWriter, new WordsFile("Testing"));
        consoleChat.start();
        File log = new File(consoleChat.getLogFile().getFilePath());
        assertThat(log.exists(), is(true));
    }

    @Test
    public void checkLogFileInputAndOutput() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Привет\nзакончить".getBytes())));
        String word = "Testing";
        File file = new File("text");
        PrintStream printStream = new PrintStream(new FileOutputStream(file));
        ConsoleChat consoleChat = new ConsoleChat(buff, printStream, new WordsFile("SomeRandomWord"));
        consoleChat.start();
        List<String> actual = consoleChat.getLogFile().getLog();
        List<String> expected = List.of("Привет", "закончить", "SomeRandomWord");
        assertThat(actual.containsAll(expected), is(true));


    }

}