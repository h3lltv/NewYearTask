import gift.api.Gift;
import gift.impl.GiftImpl;
import sweets.Candy;
import sweets.Cookie;
import sweets.Sweet;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class RunApp  {

    public static void main(String[] args)  {
        Properties prop = new Properties();
        String propFileName = "file.properties";
        try (FileOutputStream fileOutputStream = new FileOutputStream("file.properties");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            GiftImpl g = new GiftImpl();
            g.addSweet(new Sweet("asd", 0.8, 3.5));
            g.addSweet(new Sweet("Sweet", 0.9, 0.99));
            g.addSweet(new Candy("Candy", 0.9, 0.99));
            g.addSweet(new Candy("CandyTwo", 0.9, 0.99, "Vanilla"));
            g.addSweet(new Cookie("Cookie", 0.9, 0.99, "Type1"));
            System.out.println(g);
            objectOutputStream.writeObject(g);
            System.out.println("Gift weights: "+g.getTotalWeight());
            System.out.println("Gift costs "+g.getTotalCost());

            FileInputStream fileInputStream = new FileInputStream("file.properties");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            GiftImpl g1 = (GiftImpl) objectInputStream.readObject();
            System.out.println("Gift from serialization weights "+g1.getTotalWeight());
            System.out.println("Gift from serialization costs "+g1.getTotalCost());
            g1.addSweet(new Candy ("CandyTwo", 0.05, 0.1, "Cola"));
            System.out.println(g1);
            System.out.println("Gift from serialization weights "+g1.getTotalWeight());
            System.out.println("Gift from serialization costs "+g1.getTotalCost());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
