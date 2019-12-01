package gift.api;

import sweets.Sweet;

import java.util.List;
import java.util.Optional;

public interface Gift {
    List<Sweet> orderByName();
    List<Sweet> orderByValue();
    List<Sweet> orderByWeight();
    List<Sweet> getByPriceRange(double from, double to);
    List<Sweet> getByWeightRange(double from, double to);
    Optional<Sweet> getByName(String name);
    double getTotalWeight();
    double getTotalCost();
    boolean giftHasSweetWithName(String sweetName);
    boolean giftHasSweetWithPrice(double from, double to);
    boolean giftHasSweetWithWeight(double from, double to);
}
