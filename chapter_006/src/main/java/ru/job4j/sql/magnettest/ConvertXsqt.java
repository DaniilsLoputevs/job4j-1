package ru.job4j.sql.magnettest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

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


}
