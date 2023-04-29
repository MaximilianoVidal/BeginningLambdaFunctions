package unaryAndBinaryOperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class MainBinaryOperator {
    public static void main(String[] args) {

        List<String> inmLst = List.of("-juan-", "-marina-", "-olmedo-", "-maxi-", "-micaela-\n");
        BinaryOperator<String> biOp= (text,word)->text.replace(word," ");
        var text= "tres tristes tigres";
        var word= "tr";
        System.out.println(biOp.apply(text,word));
        BinaryOperator<Integer> biOp2= BinaryOperator.maxBy(Integer::compareTo);
        BinaryOperator<Integer> biOp3= BinaryOperator.minBy(Integer::compareTo);

        System.out.println(biOp2.apply(100,300));
        System.out.println(biOp3.apply(100,300));


    }
}