package ru.job4j.io;

import java.io.*;
import java.util.*;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 11.06.2019
 */
public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            boolean checkStatus = true;
            List<String> rs = new ArrayList<>();
            while (bufferedReader.ready()) {
                String check = bufferedReader.readLine();
                if (checkStatus) {
                    if (check.contains("400") || check.contains("500")) {
                        rs.add(check);
                        checkStatus = false;
                    }
                }
                if (!checkStatus) {
                    if (check.contains("200") || check.contains("300")) {
                        rs.add(check);
                        checkStatus = true;
                    }
                }
            }
            try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(target)) {
            }) {
                for (String a : rs) {
                    printWriter.write(a);
                    printWriter.write(System.lineSeparator());

                }
            }


        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Analizy analizy = new Analizy();
        analizy.unavailable("serverlog.txt", "unavailable.csv");
    }
}
