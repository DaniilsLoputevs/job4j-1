package ru.job4j.concurrency;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;

public class Downloader implements Runnable {
    private String url;
    private File outfile;
    private final int limit;

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
            int r = 0;
            outfile = new File(System.getProperty("java.io.tmpdir") + File.separator + filename);
            try (InputStream in = h.getInputStream();
                 FileWriter f = new FileWriter(outfile)) {
                while ((r = in.read()) != -1) {
                    f.write(r);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long checksize(long value, File f) {
        return f.length() - value;
    }

    public File getOutfile() {
        return outfile;
    }

//    private boolean sleepcondition(long filelenght) {
//        int now = LocalTime.now().getSecond();
//        int upd = 0;
//        boolean rs = false;
//        do {
//            if (filelenght > limit) {
//                rs = true;
//                upd = LocalTime.now().getSecond();
//            }
//        } while (now - upd > -1);
//        return rs;
//    }


    private long sizedownload(long source, long dest) {
        long updsource = source - dest;
        int now = LocalTime.now().getSecond();
        int upd = 0;
        long result = 0;
        do {
            result = (dest - updsource);
            upd = LocalTime.now().getSecond();
        } while (now - upd > -1);
        return result;
    }


}
//такт 1 4 мбайт - 2000мб = 1996мб
//такт 2 8 мбайт - 2000мб = 199