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
    private static final String PROP_PATH = "C:\\Users\\roma0\\OneDrive\\Рабочий стол\\Present\\src\\main\\resources\\file.properties";

    public static Gift createGiftFromFile(){
        GiftImpl gift = null;
        try {
            Properties prop = new Properties();
            InputStream fis = new FileInputStream(PROP_PATH);
            prop.load(fis);
            try (FileInputStream fileInputStream = new FileInputStream(prop.getProperty("loadGiftFile"));
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                gift = (GiftImpl) objectInputStream.readObject();

            } catch (IOException | ClassNotFoundException e) {
                log.error(e.getMessage());
            }
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return gift;
    }

    public static Sweet createSweetFromFile(){
        Sweet sweet = null;
        try {
            Properties prop = new Properties();
            InputStream fis = new FileInputStream(PROP_PATH);
            prop.load(fis);
            try (FileInputStream fileInputStream = new FileInputStream(prop.getProperty("loadSweetFile"));
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                sweet = (Sweet) objectInputStream.readObject();

            } catch (IOException | ClassNotFoundException e) {
                log.error(e.getMessage());
            }
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return sweet;
    }
}
