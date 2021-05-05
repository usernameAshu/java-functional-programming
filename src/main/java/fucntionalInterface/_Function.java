package fucntionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        Function<Integer,Integer> mapIncrement = _Function::increment;
        System.out.println(mapIncrement.apply(1));

        BiFunction<Integer,Integer,Integer> biFunction = _Function::incrementByOneANdMultiply;
        Integer apply = biFunction.apply(10, 15);
        System.out.println(apply.intValue());
    }

    static int increment(int n) {
        return ++n;
    }
    static int incrementByOneANdMultiply(int n, int multiplier) {
        return  (n+1)*multiplier;
    }
}
