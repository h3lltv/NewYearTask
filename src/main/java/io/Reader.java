package io;

import gift.api.Gift;
import gift.impl.GiftImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sweets.Sweet;

import java.io.*;
import java.util.Properties;

public class Reader {
    private static Logger log = LoggerFactory.getLogger(ObjectWriter.class);
    private static final String PROP_PATH = "src/main/resources/file.properties";

    public static Gift createGiftFromFile() {
        Gift gift = null;
        try (InputStream fileInputStream = new FileInputStream(getProperties().getProperty("loadGiftFile"));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            gift = (GiftImpl) objectInputStream.readObject();
            log.info("Object " + gift.getClass().getName() + " created from " + getProperties().getProperty("loadGiftFile")
            );
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return gift;
    }

    private static Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream fis = new FileInputStream(PROP_PATH);
            prop.load(fis);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return prop;
    }

    public static Sweet createSweetFromFile() {
        Sweet sweet = null;
        try (InputStream fileInputStream = new FileInputStream(getProperties().getProperty("loadSweetFile"));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            sweet = (Sweet) objectInputStream.readObject();
            log.info("Object " + sweet.getClass().getName() + " " + sweet.toString() + " created from " + getProperties().getProperty("loadGiftFile")
            );
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return sweet;
    }
}
