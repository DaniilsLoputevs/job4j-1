package ru.job4j.io.bot;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 13.07.2019
 */
public class Client {
    private Socket socket;
    private InetAddress inetAddress;
    private boolean work;

    public Client(int servport, String ip) throws IOException {
        this.inetAddress = InetAddress.getByName(ip);
        this.socket = new Socket(inetAddress, servport);
        this.work = true;

    }

    public void initial() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter output = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader dip = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            String s = null;
            while (this.work) {
                s = bf.readLine();
                output.println(s);
                output.println();
                s = dip.readLine();
                while (!s.isEmpty()) {
                    System.out.println("Server answer : " + s);
                    if ("exit".equals(s)) {
                        this.work = false;
                        break;
                    }
                    s = dip.readLine();
                }
                this.stop(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean stop(String word) throws IOException {
        boolean rs = false;
        if (word.equals("close.")) {
            this.work = false;
            rs = true;
            System.exit(0);
        }
        return rs;
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(5000, "127.0.0.1");
        client.initial();
    }
}
