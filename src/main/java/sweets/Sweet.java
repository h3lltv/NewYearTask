package sweets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Sweet implements Serializable {
    private String name;
    double weight;
    double cost;

    static Logger log = LoggerFactory.getLogger(Sweet.class);

    public Sweet(String name, double weight, double cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        if (name.isEmpty()) {
            log.error("Incorrect name data. Value of name is empty!");
            throw new IllegalArgumentException("Name can't be empty!");
        }
        else {
            return name;
        }
    }

    public double getWeight() {
        if (weight <= 0) {
            log.error("Negative weight value");
            throw new IllegalArgumentException("Weight must have positive value");
        }
        else {
            return weight;
        }
    }

    public double getCost() {
        if (cost <= 0) {
            log.error("Incorrect cost data");
            throw new IllegalArgumentException("Cost must have positive value");
        }
        else {
            return cost;
        }
    }

    @Override
    public String toString() {
        return "Sweet "+ getName()+ ", cost "+ getCost()+", weight "+getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sweet)) return false;

        Sweet sweet = (Sweet) o;

        if (Double.compare(sweet.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(sweet.getCost(), getCost()) != 0) return false;
        return getName().equals(sweet.getName());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
