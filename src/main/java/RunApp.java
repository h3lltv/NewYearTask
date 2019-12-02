import gift.impl.GiftImpl;
import io.ObjectWriter;
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
        Sweet s = new Sweet("name", 0.5, 2.75);
        ObjectWriter.saveToFile(g);
        ObjectWriter.saveToFile(s);
        ObjectWriter.saveToFile(g,"file.txt");

//        try (FileOutputStream fileOutputStream = new FileOutputStream("output.out");
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//
//            objectOutputStream.writeObject(g);
//            System.out.println("Gift weights: "+g.getTotalWeight());
//            System.out.println("Gift costs "+g.getTotalCost());
//
//            FileInputStream fileInputStream = new FileInputStream("output.out");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            GiftImpl g1 = (GiftImpl) objectInputStream.readObject();
//            System.out.println("Gift from serialization weights "+g1.getTotalWeight());
//            System.out.println("Gift from serialization costs "+g1.getTotalCost());
//            g1.addSweet(new Candy ("CandyTwo", 0.05, 0.1, "Cola"));
//            System.out.println(g1);
//            System.out.println("Gift from serialization weights "+g1.getTotalWeight());
//            System.out.println("Gift from serialization costs "+g1.getTotalCost());
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(Arrays.toString(e.getStackTrace()));
//        }
    }
}
