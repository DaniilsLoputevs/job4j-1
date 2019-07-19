package ru.job4j.io.bot;


import org.junit.Test;
import ru.job4j.io.iochat.WordsFile;

import java.io.*;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    @Test
    public void outputData() throws IOException {
        Socket socket = mock(Socket.class);
        Server server = new Server(socket, new WordsFile("пока"));
        String test = "закончить";
        ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        server.outputData();
        assertThat(out.toString(), is("пока\r\n\r\n"));
    }


}