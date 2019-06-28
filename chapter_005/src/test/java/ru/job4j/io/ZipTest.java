package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ZipTest {


    @Test
    public void seekBy() throws IOException {
        String path = (System.getProperty("java.io.tmpdir") + "testcase2");
        String output = (System.getProperty("java.io.tmpdir") + "pr.zip");
        String[] arguments = new String[]{"-d", path, "-e", "zip", "-o", output};
        Zip zip = new Zip(arguments);
        File root = new File(path);
        root.mkdirs();
        File folder1 = new File(root, "folder_1");
        File folder2 = new File(root, "folder_2");
        folder1.mkdirs();
        folder2.mkdirs();
        File txt1 = new File(path, "textfile_1.txt");
        File txt2 = new File(folder2, "textfile_2.txt");
        txt2.createNewFile();
        txt1.createNewFile();
        File doc = new File(folder1, "docfile_1.doc");
        File fzip = new File(folder2, "arc.zip");
        doc.createNewFile();
        fzip.createNewFile();
        List<File> a = new ArrayList<>();
        a.add(root);
        a.add(folder1);
        a.add(folder2);
        a.add(txt1);
        a.add(txt2);
        a.add(doc);
        List<File> rs = zip.seekBy(path, "zip");
        assertThat(a.containsAll(rs), is(true));


    }

    @Test
    public void pack() throws IOException {
        String path = (System.getProperty("java.io.tmpdir") + "testcase2");
        String output = (System.getProperty("java.io.tmpdir") + "pr.zip");
        String[] arguments = new String[]{"-d", path, "-e", "zip", "-o", output};
        Zip zip = new Zip(arguments);
        File root = new File(path);
        root.mkdirs();
        File folder1 = new File(root, "folder_1");
        File folder2 = new File(root, "folder_2");
        folder1.mkdirs();
        folder2.mkdirs();
        File txt1 = new File(path, "textfile_1.txt");
        File txt2 = new File(folder2, "textfile_2.txt");
        txt2.createNewFile();
        txt1.createNewFile();
        File doc = new File(folder1, "docfile_1.doc");
        File fzip = new File(folder2, "arc.zip");
        doc.createNewFile();
        fzip.createNewFile();
        File a = new File(output);
        zip.pack(zip.seekBy(path, "zip"), new File(output));
        assertThat(a.exists(), is(true));


    }

}