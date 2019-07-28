package ru.job4j.io.finder;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FinderTest {

    @Test
    public void whenStartAppAndCreateOutputFileWhenFinish() throws IOException {
        String path = (System.getProperty("java.io.tmpdir") + File.separator + "finderpath");
        String out = (System.getProperty("java.io.tmpdir") + File.separator + "finderpath" + File.separator + "R.txt");
        String name = "user";
        File file1 = new File(path);
        file1.mkdirs();
        File file = new File(path, "user.txt");
        file.createNewFile();
        String[] arg = new String[]{"-d", path, "-n", name, "-m", "-o", out};
        Finder f = new Finder(arg);
        f.startFinder();
        File outfile = new File(out);
        assertThat(outfile.exists(), is(true));
        outfile.delete();
        file.delete();
        file1.delete();
    }


    @Test
    public void whenFileInsertDeepAndAfterWorkReadResultFile() throws IOException {
        String path = (System.getProperty("java.io.tmpdir") + File.separator + "finderpath");
        String out = (System.getProperty("java.io.tmpdir") + File.separator + "finderpath" + File.separator + "log.txt");
        String name = "testfile.txt";
        File root = new File(path);
        root.mkdirs();
        File deepdir1 = new File(root, "deepdir1");
        deepdir1.mkdirs();
        File deepdir2 = new File(deepdir1, "deepdir2");
        deepdir2.mkdirs();
        File find = new File(deepdir2, "testfile.txt");
        File find2 = new File(deepdir2, "testfile.jpg");
        find.createNewFile();
        find2.createNewFile();
        String[] arg = new String[]{"-d", path, "-n", name, "-f", "-o", out};
        Finder finder = new Finder(arg);
        finder.startFinder();
        File outfile = new File(out);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(outfile));
        String s = bufferedReader.readLine();
        assertThat(outfile.exists(), is(true));
        assertThat(s, is("testfile.txt"));
        outfile.delete();
        find.delete();
        find2.delete();
        deepdir2.delete();
        deepdir1.delete();
        root.delete();
    }

}