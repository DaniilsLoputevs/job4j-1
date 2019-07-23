package ru.job4j.io;

import org.junit.Test;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchTest {


    @Test
    public void checkEqualityReturnValueOnFilesUse() throws IOException {
        Search search = new Search();
        List<String> check = new ArrayList<>();
        check.add("txt");
        String path = System.getProperty("java.io.tmpdir") + File.separator + "testcase";
        File rootFolder = new File(path);
        rootFolder.mkdirs();
        File firstFolder = new File(rootFolder, "first_01");
        firstFolder.mkdirs();
        File textfile1 = new File(firstFolder, "textfile_01.txt");
        textfile1.createNewFile();
        File drawfile1 = new File(firstFolder, "draw.bmp");
        drawfile1.createNewFile();
        File secondFolder = new File(rootFolder, "folder_02");
        secondFolder.mkdirs();
        File textfile2 = new File(secondFolder, "textfile_02.txt");
        textfile2.createNewFile();
        File filerootfolder = new File(rootFolder, "textfile_03.txt");
        filerootfolder.createNewFile();
        List<File> rs = new ArrayList<>();
        rs.add(textfile1);
        rs.add(textfile2);
        rs.add(filerootfolder);
        assertThat(search.files(path, check).containsAll(rs), is(true));
    }
}