package ru.job4j.sql.magnettest;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConvertXsqtTest {

    @Test
    public void file() {
        ConvertXsqt convertXsqt = new ConvertXsqt();
        File file = new File(System.getProperty("java.io.tmpdir") + File.separator + "sheme.xsd");
        String xsl = "<?xml version=\"1.0\"?>\n"
                +
                "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"
                +
                "<xsl:template match=\"/\">\n"
                +
                "<entries>"
                +
                "   <xsl:for-each select=\"entries/entry\">\n"
                +
                "       <entry>"
                +
                "           <xsl:attribute name=\"field\">"
                +
                "               <xsl:value-of select=\"field\"/>"
                +
                "           </xsl:attribute>"
                +
                "       </entry>\n"
                +
                "   </xsl:for-each>\n"
                +
                " </entries>\n"
                +
                "</xsl:template>\n"
                +
                "</xsl:stylesheet>\n";
        convertXsqt.file(xsl);
        assertThat(file.exists(), is(true));
    }
}