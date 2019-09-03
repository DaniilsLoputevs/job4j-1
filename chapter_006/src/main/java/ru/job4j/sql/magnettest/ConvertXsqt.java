package ru.job4j.sql.magnettest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;

public class ConvertXsqt {
    private static final Logger LOG = LogManager.getLogger(ConvertXsqt.class.getName());

    /**
     * Конвертирует входящий input xml файл в dest xml используя cхему sheme
     *
     * @param input  входящий файл xml
     * @param dest   исходящий преобразованный файл xml
     * @param scheme схема преобразования
     */
    public void convert(File input, File dest, File scheme) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer(new StreamSource(scheme));
            t.transform(new StreamSource(scheme), new StreamResult(dest));
        } catch (TransformerException e) {
            LOG.error("Error in convert()", e);
            e.printStackTrace();
        }

    }

    public void file(String s) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(System.getProperty("java.io.tmpdir") + File.separator + "sheme.xsd"))) {
            byte[] v = s.getBytes();
            fileOutputStream.write(v);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Pars {
        int count = 0;

        public static void parsing(File file) {

            DefaultHandler defaultHandler = new DefaultHandler() {
                boolean check = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equals("field")) {
                        check = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (check) {
                        check = false;
                    }
                }
            };

            try {
                SAXParserFactory spf = SAXParserFactory.newInstance();
                SAXParser parser = spf.newSAXParser();
                parser.parse(file, defaultHandler);


            } catch (Exception e) {
                LOG.error("error in parsing()", e);
            }
        }
    }


    public static void main(String[] args) {
        ConvertXsqt convertXsqt = new ConvertXsqt();
        File in = new File(System.getProperty("java.io.tmpdir") + File.separator + "tmp.xml");
        File dest = new File("/home/eveletspb/one.xml");
        File scheme = new File(System.getProperty("java.io.tmpdir") + File.separator + "sheme.xsd");
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
        convertXsqt.convert(in, dest, scheme);
    }


}



