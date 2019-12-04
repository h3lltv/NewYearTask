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

    private List<Sweet> gift = new ArrayList<>();

    private static Logger log = LoggerFactory.getLogger(GiftImpl.class);

    public void addSweet(Sweet s) {
        this.gift.add(s);
    }

    private List<String> getNameList() {
        return this.gift.stream()
                .map(Sweet::getName)
                .collect(Collectors.toList());
    }

    private List<Double> getPriceList() {
        return this.gift.stream()
                .map(Sweet::getCost)
                .collect(Collectors.toList());
    }

    private List<Double> getWeightList() {
        return this.gift.stream()
                .map(Sweet::getWeight)
                .collect(Collectors.toList());
    }

    @Override
    public void orderByName() {
        this.gift.sort(Comparator.comparing(Sweet::getName));
    }

    @Override
    public void orderByPrice() {
        this.gift.sort(Comparator.comparing(Sweet::getCost));
    }

    @Override
    public void orderByWeight() {
        this.gift.sort(Comparator.comparingDouble(Sweet::getWeight));
    }

    @Override
    public List<Sweet> getByPriceRange(double from, double to) {
        if (giftHasSweetWithPrice(from, to)) {
            return this.gift
                    .stream()
                    .filter(s -> s.getCost() >= from && s.getCost() <= to)
                    .collect(Collectors.toList());
        } else {
            log.error("Can't find sweets is such weight range");
            throw SweetNotFoundException.sweetNotFoundByPriceException(from, to);
        }
    }

    public List<Sweet> getByPriceRange(double upTo) {
        return getByPriceRange(0, upTo);
    }

    @Override
    public List<Sweet> getByWeightRange(double from, double to) {
        if (giftHasSweetWithWeight(from, to)) {
            return this.gift
                    .stream()
                    .filter(s -> s.getWeight() >= from && s.getWeight() <= to)
                    .collect(Collectors.toList());
        } else {
            log.error("Can't find sweets is such price range");
            throw SweetNotFoundException.sweetNotFoundByWeightException(from, to);
        }
    }

    public List<Sweet> getByWeightRange(double upTo) {
        return getByWeightRange(0, upTo);
    }

    @Override
    public Optional<Sweet> getByName(String name) {
        if (giftHasSweetWithName(name)) {
            return this.gift
                    .stream()
                    .findAny();
        } else {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.gift.forEach(sweet -> {
            sb.append(sweet);
            sb.append("\n");
        });
        return new String(sb);
    }
}
