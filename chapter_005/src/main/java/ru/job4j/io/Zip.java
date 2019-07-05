package ru.job4j.io;


import java.io.*;
import java.util.List;


import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 21.06.2019
 */
public class Zip {
    private Args args;

    public Zip(String[] args) {
        this.args = new Args(args);

    }

    public List<File> seekBy(String root, String ext) {
        Search search = new Search();
        List<File> rs = search.filesWithFold(root, ext);
        return rs;
    }


    public void pack(List<File> source, File target) {
        try (
                ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(target))) {
            for (File file : source) {
                if (!file.isDirectory()) {
                    zip.putNextEntry(new ZipEntry(file.getPath().substring(this.args.directory().length() + 1)));
                    DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
                    byte[] b = inputStream.readAllBytes();
                    zip.write(b);
                    zip.closeEntry();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Zip zip = new Zip(args);
        List<File> s = zip.seekBy(zip.args.directory(), zip.args.ex());
        zip.pack(s, new File(zip.args.output()));
    }


}



