package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import java.util.Properties;

public class ObjectWriter {
    private static Logger log = LoggerFactory.getLogger(ObjectWriter.class);
    private static final String PROP_PATH = "C:\\Users\\roma0\\OneDrive\\Рабочий стол\\Present\\src\\main\\resources\\file.properties";

    public static void saveToFile(Object o) {
        try {
            Properties prop = new Properties();
            InputStream fis = new FileInputStream(PROP_PATH);
            prop.load(fis);
            try (FileOutputStream fileOutputStream = new FileOutputStream(prop.getProperty("saveGiftFile"));
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(o);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void saveToFile(Object o, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName+".out");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(o);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
