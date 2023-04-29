package chapter07.funcionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

// predicate is an abstract method, text type. Evaluates two type values and return a boolean
public class MainPredicate {
    public static void main(String[] args) {
        Predicate<Object> isString = e->e instanceof String;
        var result = usingPredicate("un string",isString)?"es un string":"no es un string";
        System.out.println(result);
        Predicate<Float> isGreaterThanZero = value -> value > 0;
        Predicate<Float> isLowerThan700 = value -> value < 700;
        Predicate<Float> orPredicate= value->Float.isInfinite(value);
        Predicate<Float> notPredicate = Predicate.not(isGreaterThanZero);

        var valide= usingPredicate2(677f,isGreaterThanZero,isLowerThan700,orPredicate);

        var result1 = valide?"accepted value": "declined value";
        System.out.println(result1);

        BiPredicate<Integer,Integer> isHigher= MainPredicate::isHigher;
        System.out.println("is lower the first number? "+ isHigher.negate().test(213,33));

    }

    public static boolean isHigher(Integer i, Integer y){
        return i>y;
    }

    private static <T> boolean usingPredicate (T value, Predicate<T> predicate){
        return predicate.test(value);
    }
    private static <T> boolean usingPredicate2(T value,
                           Predicate<T> predicate, Predicate<T>andPredicate,Predicate<T>orPredicate){
        return predicate.and(andPredicate).or(orPredicate).test(value);

    }

}
