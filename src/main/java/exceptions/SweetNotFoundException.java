package exceptions;

import java.io.Serializable;

public class SweetNotFoundException extends RuntimeException implements Serializable {
    private static final String COMMON_MESSAGE_SNIPPET = " not found";

    public SweetNotFoundException(String message) {
        super(message);
    }

    public static SweetNotFoundException sweetNotFoundByNameException(String name) {
        return new SweetNotFoundException("Gift with " + name + COMMON_MESSAGE_SNIPPET);
    }

    public static SweetNotFoundException sweetNotFoundByPriceException(double from, double to) {
        return new SweetNotFoundException("Sweets in gift with price from " + from + " to " + to + COMMON_MESSAGE_SNIPPET);
    }

    public static SweetNotFoundException sweetNotFoundByWeightException(double from, double to) {
        return new SweetNotFoundException("Sweets in gift with weight from " + from + " to " + to + COMMON_MESSAGE_SNIPPET);
    }

    public static SweetNotFoundException noSuchSweetException(String name){
        return new SweetNotFoundException ("Sweet with name "+name+ COMMON_MESSAGE_SNIPPET);
    }

}
