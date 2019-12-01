package gift.impl;

import exceptions.SweetNotFoundException;
import gift.api.Gift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sweets.Sweet;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class GiftImpl implements Gift, Serializable {

    public List<Sweet> gift = new ArrayList<>();

    private static Logger log = LoggerFactory.getLogger(GiftImpl.class);

    public void addSweet(Sweet s){
        this.gift.add(s);
    }

    public List<String> getNameList() {
        return this.gift.stream()
                .map(Sweet::getName)
                .collect(Collectors.toList());
    }
    public List<Double> getPriceList() {
        return this.gift.stream()
                .map(Sweet::getCost)
                .collect(Collectors.toList());
    }
    public List<Double> getWeightList() {
        return this.gift.stream()
                .map(Sweet::getWeight)
                .collect(Collectors.toList());
    }

    @Override
    public List<Sweet> orderByName() {
        return this.gift
                .stream()
                .sorted(Comparator.comparing(Sweet::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Sweet> orderByValue() {
        return this.gift
                .stream()
                .sorted(Comparator.comparing(Sweet::getCost))
                .collect(Collectors.toList());
    }

    @Override
    public List<Sweet> orderByWeight() {
        return this.gift
                .stream()
                .sorted(Comparator.comparing(Sweet::getWeight))
                .collect(Collectors.toList());
    }

    @Override
    public List<Sweet> getByPriceRange(double from, double to) {
        if (giftHasSweetWithPrice(from, to)) {
            return this.gift
                    .stream()
                    .filter(weight -> weight.getCost() >= from && weight.getCost() <= to)
                    .collect(Collectors.toList());
        }
        else{
            log.error("Can't find sweets is such weight range");
            throw SweetNotFoundException.sweetNotFoundByPriceException(from, to);
        }
    }

    public List<Sweet> getByPriceRange(double upTo){
        return getByPriceRange(0, upTo);
    }

    @Override
    public List<Sweet> getByWeightRange(double from, double to) {
        if (giftHasSweetWithWeight(from, to)) {
            return this.gift
                    .stream()
                    .filter(weight -> weight.getCost() >= from && weight.getCost() <= to)
                    .collect(Collectors.toList());
        }
        else{
            log.error("Can't find sweets is such price range");
            throw SweetNotFoundException.sweetNotFoundByWeightException(from, to);
        }
    }

    public List<Sweet> getByWeightRange(double upTo){
        return getByWeightRange(0, upTo);
    }

    @Override
    public Optional<Sweet> getByName(String name) {
        if(giftHasSweetWithName(name)){
            return this.gift
                    .stream()
                    .findAny();
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public double getTotalWeight() {
        return this.gift.stream().mapToDouble(Sweet::getWeight).sum();
    }

    @Override
    public double getTotalCost() {
        return this.gift.stream().mapToDouble(Sweet::getCost).sum();
    }

    @Override
    public boolean giftHasSweetWithName(String name) {
        return this.getNameList().contains(name);
    }

    @Override
    public boolean giftHasSweetWithPrice(double from, double to) {
        return getPriceList()
                .stream()
                .mapToDouble(price -> price)
                .anyMatch(price -> price >= from && price <= to);
    }

    @Override
    public boolean giftHasSweetWithWeight(double from, double to) {
        return getWeightList()
                .stream()
                .mapToDouble(weight -> weight)
                .anyMatch(weight -> weight >= from && weight <= to);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        this.gift.forEach(sb::append);
        return new String(sb);
    }
}
