package ru.job4j.concurrency;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader implements Runnable {
    private String url;
    private int limit;

    public Downloader(String url, int limit) {
        this.url = url;
        this.limit = limit;
    }


    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            String filename = url.getFile();
            filename = filename.substring(filename.lastIndexOf("/") + 1);
            HttpURLConnection h = (HttpURLConnection) url.openConnection();
            long sizefile = h.getContentLength();
            byte[] buffer = new byte[4096];
            int r = 0;
            File outfile = new File(System.getProperty("java.io.tmpdir") + File.separator + filename);
            try (InputStream in = h.getInputStream();
                 FileOutputStream f = new FileOutputStream(outfile)) {
                while ((r = in.read(buffer)) != -1) {
                    f.write(buffer, 0, r);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
