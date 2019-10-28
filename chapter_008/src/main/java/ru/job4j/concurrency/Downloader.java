package ru.job4j.concurrency;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader implements Runnable {
    private String url;
    private File outfile;
    private final int limit;

    public Downloader(String url, int limit) {
        this.url = url;
        this.limit = limit * 1024;
    }

    /**
     * Метод скачивает файл по указанной ссылке в конструкторе с ограничением указанным в кбайтах
     * Алгоритм : Суммирующая переменная считает кол скаченных байтов и проверяет в методе cheksum() дошли ли до ограничения limit
     * Внутреннее условие проверяет прошло ли меньше 1 секунды пока суммирующая переменная набирает определенное значение байтов.
     * Поток засыпает если условие возвращает true.
     */
    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            String filename = url.getFile();
            filename = filename.substring(filename.lastIndexOf("/") + 1);
            HttpURLConnection h = (HttpURLConnection) url.openConnection();
            outfile = new File(System.getProperty("java.io.tmpdir") + File.separator + filename);
            byte[] bytes = new byte[4096];
            int r = 0;
            long sum = 0;
            try (InputStream in = h.getInputStream();
                 OutputStream f = new FileOutputStream(outfile)) {
                long start = System.currentTimeMillis();
                while ((r = in.read(bytes)) != -1) {
                    f.write(bytes, 0, r);
                    sum += r;
                    if (checksum(sum)) {
                        System.out.println("Лимит по скорости достигнут:" + sum);
                        if (sleepcondition(start)) {
                            Thread.sleep(1000L - (System.currentTimeMillis() - start));
                            System.out.println("Поток уснул");
                        }
                        start = System.currentTimeMillis();
                        sum = 0;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Утилитный метод принимающий значение скаченых байтов в сумме.
     *
     * @param value сумма байтов поступивших их потока
     * @return true/false
     */
    private boolean checksum(long value) {
        return value >= limit;
    }

    /**
     * Утилитный метод  для условия усыпления потока
     *
     * @param value - временное значение для проверки
     * @return true/false
     */
    private boolean sleepcondition(long value) {
        return ((System.currentTimeMillis() - value) <= 1000L);
    }

}