package sweets;

public class Cookie extends Sweet {

    private String type;

    public Cookie(String name, double weight, double price, String type){
        super(name, weight, price);
        this.type=type;
    }

    public Cookie(String name, double weight, double price){
        super(name, weight, price);
    }

    public String getType() {
        if (type.isEmpty()) {
            log.error("Incorrect name. Such sweet doesn't exist!");
            throw new IllegalArgumentException("Type is empty");
        } else {
            return type;
        }
    }

    @Override
    public double getCost() {
        if (this.cost <= 0) {
            log.error("Incorrect cost data");
            throw new IllegalArgumentException("Cost must have positive value");
        }
        else {
            return this.weight/this.cost;
        }
    }
    @Override
    public String toString() {
        String  s ="Cookie "+ getName()+ ", cost "+ getCost()+", weight "+getWeight() ;
        if(this.type != null) return s+ ", type " + type+" ";
        else return s;
    }
}
