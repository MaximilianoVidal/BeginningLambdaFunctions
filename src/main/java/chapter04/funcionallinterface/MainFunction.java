package chapter04.funcionallinterface;


import java.time.LocalDate;
import java.util.function.Function;

public class MainFunction {
    public static void main(String[] args) {

        var chain = new StringBuilder("Using the interface");
        Function <StringBuilder,String>ToString=in->in.append("Function").toString();
        System.out.println(usingFunction(ToString,chain));

        var birth= LocalDate.of(1999,05,03);

        Function<LocalDate,Integer> returnAge= date->date.until(LocalDate.now()).getYears();
        Function<Integer,Sub>returnSub= Sub::new;// equals to = returnSub=age-> new Sub(age);
        Function<Sub,String> returnToString= Sub::toString;
        System.out.println(usingFunWithCompose(returnToString,returnSub,returnAge,birth));


        var sub= new Sub(19);
        Function <Sub,Integer>returnAge1=Sub::getAge;
        Function <Integer,LocalDate>returnBirth=age->{
                var now=LocalDate.now();
                return LocalDate.of(now.getYear()-age,now.getMonth(),now.getDayOfMonth());
        };
        Function <LocalDate,String> returnString= LocalDate::toString;

        System.out.println(usingFunWithAndThen(returnAge1,returnBirth,returnString,sub));


    }
    private static <T,R,V,O> O usingFunWithAndThen
            (Function<T,R> fun, Function<R,V>fun1,Function<V,O>fun2,T value){
        return fun.andThen(fun1)
                .andThen(fun2)
                .apply(value);

    }

    private static <T,R> R usingFunction(Function<T,R> fun,T value){
        return fun.apply(value);
    }
    private static <T,R,V,O>R usingFunWithCompose
            (Function<T,R> fun, Function<V,T>fun1,Function<O,V>fun2,O value){
        return fun.compose(fun1)// function1 calls a compose method and return another function
                .compose(fun2)//function 2 receive a value type O and return a value type V
                .apply(value );//calls first to the value of function2'O', then function1'V'
    }


}
