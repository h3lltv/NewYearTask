package gift.api;

import sweets.Sweet;

import java.util.List;
import java.util.Optional;

public interface Gift {
    void orderByName();

    void orderByPrice();

    void orderByWeight();

    List<?> getByPriceRange(double from, double to);

    List<?> getByWeightRange(double from, double to);

    Optional<?> getByName(String name);

    double getTotalWeight();

    double getTotalCost();

    boolean giftHasSweetWithName(String sweetName);

    boolean giftHasSweetWithPrice(double from, double to);

    boolean giftHasSweetWithWeight(double from, double to);
}
