package sweets;

import exceptions.SweetNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class Sweet implements Serializable {
    protected String name;
    protected double weight;
    protected double cost;

    protected static Logger log = LoggerFactory.getLogger(Sweet.class);

    public Sweet(String name, double weight, double cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        if (name.isEmpty()) {
            log.error("Incorrect name data. Value of name is empty!");
            throw SweetNotFoundException.sweetNotFoundByNameException("xyi");
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
}
