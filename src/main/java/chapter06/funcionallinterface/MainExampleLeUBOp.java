package chapter06.funcionallinterface;
// UNARY OPERATOR/ Binary Operator-> They are part of function

import java.util.List;
import java.util.function.BinaryOperator;

public class MainExampleLeUBOp {
    public static void main(String[] args) {
        List<String> inmLst= List.of("-juan-","-Laura-","-Barby-","-Maxi-");//@formater:on
        BinaryOperator<String> biOperator= (text,word)-> text.replace(word,"puta");

        var text =" though, thought, tough, although y through";
        var word= "th";
        System.out.println(biOperator.apply(text,word));

        BinaryOperator<Integer>binaryOp2= BinaryOperator.maxBy(Integer::compareTo);
        BinaryOperator<Integer>binaryOp3= BinaryOperator.minBy(Integer::compareTo);
        System.out.println(binaryOp2.apply(1000,300));
        System.out.println(binaryOp3.apply(20,100));

        //usingUnaryOperator(String::toUpperCase,inmLst).forEach(System.out::println);
        // System.out.println();
        // usingUnaryOperator(String::toLowerCase,inmLst).forEach(System.out::println);
        // System.out.println();
        //
        // usingUnaryOperatorAndThen(String::toUpperCase,String::strip,inmLst)
        //         .forEach(System.out::println);//strip quit the space between the words
    }



    /*private static <T> List<T> usingUnaryOperator(UnaryOperator<T> unOp,List<T>lst){
        List<T> newLst = new ArrayList<>();
        lst.forEach(element-> newLst.add(unOp.apply(element)));
        return newLst;
    }*/

   /* private static <T> List<T> usingUnaryOperatorAndThen(UnaryOperator<T> unOp,
                                                         UnaryOperator<T> unOp2,List<T>lst){
        List<T> newLst = new ArrayList<>();
        lst.forEach(element-> newLst.add(unOp.andThen(unOp2).apply(element)));
        return newLst;
    }*/

}
