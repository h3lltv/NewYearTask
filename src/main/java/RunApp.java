import gift.api.Gift;
import gift.impl.GiftImpl;
import io.ObjectWriter;
import io.Reader;
import sweets.Candy;
import sweets.Cookie;
import sweets.Sweet;

public class RunApp  {

    public static void main(String[] args)  {
        GiftImpl g = new GiftImpl();
        g.addSweet(new Sweet("OtherSweet", 0.8, 3.5));
        g.addSweet(new Sweet("Caramel", 0.9, 0.99));
        g.addSweet(new Candy("Candy", 0.9, 0.99));
        g.addSweet(new Candy("CandyTwo", 0.9, 0.99, "Vanilla"));
        g.addSweet(new Candy("CandyTwo", 0.9, 0.99, "Menthol"));
        g.addSweet(new Cookie("Cookie", 0.9, 0.99, "Type1"));
        g.addSweet(new Cookie("Cookie", 0.9, 0.9));
        System.out.println(g);
        g.orderByName();
        System.out.println(g);
        g.orderByPrice();
        System.out.println(g);
        g.orderByWeight();
        System.out.println(g);
        ObjectWriter.saveToFile(g);
        Sweet s = new Sweet("name", 0.5, 2.75);
        Gift g2 = Reader.createGiftFromFile();
        System.out.println(g2);
        ObjectWriter.saveToFile(s, "sweetOutput");
        Sweet sweet = Reader.createSweetFromFile();
        System.out.println(sweet);
    }
}
