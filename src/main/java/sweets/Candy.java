package sweets;

import exceptions.SweetNotFoundException;

public class Candy extends Sweet {

    private String flavor;

    public Candy(String name, double weight, double price, String flavor) {
        super(name, weight, price);
        this.flavor = flavor;
    }

    public Candy(String name, double weight, double price) {
        super(name, weight, price);
    }

    public String getFlavor() {
        if (flavor.isEmpty()) {
            log.error("Incorrect name. Such sweet doesn't exist!");
            throw SweetNotFoundException.noSuchSweetException("");
        } else {
            return flavor;
        }
    }

    @Override
    public String toString() {
        String s = "Candy " + getName() + ", cost " + getCost() + ", weight " + getWeight();
        if (this.flavor != null) return s + " " + this.flavor;
        else return s;
    }
}
