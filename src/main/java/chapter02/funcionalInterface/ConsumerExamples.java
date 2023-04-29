package chapter02.funcionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

//API stream
// consumer es una interface that contains 1 abstract method. accept values
// returns nothing->void method. the parameter is type T-> any type
public class ConsumerExamples {
    static List<Object> lst = new ArrayList<>();

    public static void main(String[] args) {
        lst.add("Hello World");
        lst.add(2020);
        lst.add(true);
        lst.add(48.88f);
        /*usingConsumer("hi im a value type T", System.out::println
                     ,lst::add,ConsumerExamples::printlst);*/
       usingBiConsumer(4,1000,
               ConsumerExamples::printbefore,lst::add,ConsumerExamples::printAfter);
    }

    private static void printAfter(Integer e, Integer v) {
        System.out.println("en the index: "+ e +" tries to add the element "+ v);
        lst.forEach(System.out::println);
    }
    private static void printbefore(Integer e, Integer v) {
        System.out.println("en the index: "+ e +" tries to add the element "+ v);
    }

    private static  <T,U> void usingBiConsumer(T oneValue, U otherValue,BiConsumer<T,U> bicosumer,
                                               BiConsumer<T,U> bicosumer2,BiConsumer<T,U> bicosumer3) {
      bicosumer.andThen(bicosumer2).andThen(bicosumer3).accept(oneValue,otherValue);

    }

    private static <T> void printlst(T value) {
        System.out.println("added to the list el valor: "+ value+"-- total values in the list:");
        lst.forEach(System.out::println);
    }

    // consumer accept other value. named and then.
    private static <T> void usingConsumer(T value, Consumer<T> consume,Consumer<T>consumer2, Consumer<T>consumer3) {
        /*its need to accept the values inside the method
        consume.accept(value);
        consumer2.accept(value);
        consumer3.accept(value);*/

        // to do it faster and simpler you can create a var type consumer
        var consumerCompleted= consume.andThen(consumer2)
                .andThen(consumer3);

        consumerCompleted.accept(value);
    }

}
