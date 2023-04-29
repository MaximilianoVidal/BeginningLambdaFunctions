package unaryAndBinaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

//unari-> extends function
public class MainExampleUBop {
    public static void main(String[] args) {

        List <String> inmLst= List.of("-juan-","-marina-","-olmedo-","-maxi-","-micaela-\n");

        usingUnaryOperator(String::toUpperCase,inmLst)
                .forEach(System.out::println);

        usingUnaryOperatorAndThen(String::toUpperCase,String::strip,inmLst)
                .forEach(System.out::println);


    }
    private static <T> List<T>  usingUnaryOperator(UnaryOperator<T>unOp,List<T>list){
        List<T> newLst= new ArrayList<>();
        list.forEach(element->newLst.add(unOp.apply(element)));
        return newLst;
    }
    private static <T> List<T>  usingUnaryOperatorAndThen(UnaryOperator<T>unOp,
                                                          UnaryOperator<T>unOp2,List<T>list){

        List<T> newLst= new ArrayList<>();
        list.forEach(element->newLst.add(unOp.andThen(unOp2).apply(element)));
        return newLst;
    }

}
