package ru.job4j.sql.magnettest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;


public class StoreXml {
    private File destination;

    public StoreXml(File target) {
        this.destination = target;
    }

    /**
     * Метод сохраняет из коллекции в файл
     *
     * @param list
     */
    public void savedata(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Entries entries = new Entries();
            entries.setEntryList(list);
            marshaller.marshal(entries, this.destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StoreSql storeSql = new StoreSql(new Config());
        storeSql.generate(10);
        StoreXml storeXml = new StoreXml(new File("/home/eveletspb/test.xml"));
        storeXml.savedata(storeSql.load());
    }
}
