package chapter05.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

// bifunctional: it's an interface that return one value, and receives two arguments
// as default bring back another biFunction with one andThen witch receives a function
public class MainBiFunction {
    public static void main(String[] args) {

        System.out.println(usingBiFunction("valor1","valor2",
                        String::endsWith));
// contains receive a value and returns another from other nature
        System.out.println(usingBiFunctionAndThen("up",
                "up"
                ,String::equals,
                MainBiFunction::sendResponse));

    }
    private static String sendResponse(boolean e){
        return e?"are equals":"are different";
    }

    private static <T,U,R>R usingBiFunction(T value, U value2, BiFunction<T,U,R>bifun){
        return bifun.apply(value,value2);
    }


    private static <T,U,R,O>O usingBiFunctionAndThen
            (T value, U value2, BiFunction<T,U,R>bifun, Function<R,O>fun){
        return bifun.andThen(fun)
                .apply(value,value2);
    }

}
/*  System.out.println(usingBiFunction(List.of(1,2,3,4,5,6,7),
                4,List::contains));*/