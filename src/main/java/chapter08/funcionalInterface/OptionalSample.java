package chapter08.funcionalInterface;

import java.util.Optional;

public class OptionalSample {
    public static void main(String[] args) throws Exception{
        Optional<String>value = Optional.ofNullable(null);//-> optional.of doesn't accept null values.
        // throws an error
        value.ifPresent(System.out::println);//-> similar to sout(value.get())
        Runnable emptyAction=()-> System.out.println("the value is null");
        value.ifPresentOrElse(System.out::println,emptyAction);

        var name = value.orElse("unknown");
        System.out.println("name of the motherfucker "+name);


        System.out.println(value.isEmpty()?"es null pa":"accept operation");
        System.out.println(result("identifier","no meaning just a word"));
        System.out.println(result2("hi ","reserve value"));
        System.out.println(result3(null,"lambda"));
        System.out.println(result4("//"+"  "+"//","barby & ken"));
        System.out.println(result5(5,7));


    }
    public static String result(String value, String otherValue){
        //we obtain a value if it isn't null.
        return Optional.ofNullable(value).orElse(otherValue) ;// orElseGet-> accept a supplier
        //()->nameOfVariant to accept a value that's not a type supplier
    }

    public static String result2(String value, String OtherValue){
        var otherVal= Optional.of(OtherValue).get();// .of-> to accept the income value.
        //.get to return the operation

        var  concatOpt = Optional.of(value).get().concat(OtherValue);
        return Optional.of(concatOpt).get();
    }


    public static String result3 (String value,String otherValue) throws Exception{//needed to throw an exception
        var otherValueOrElseThrow= Optional.ofNullable(otherValue)
                     .orElseThrow(Exception::new); // orElseThrow accepts a Supplier= accept an objet

        return Optional.ofNullable(value)
                .orElse(otherValueOrElseThrow);
    }

    public static String result4 (String value,String otherValue){
        return Optional.ofNullable(value).filter(String::isBlank).orElse(otherValue);
    }

    public static Integer result5 (Integer value,Integer otherValue){
        return Optional.of(Integer.sum(value,otherValue))
                .filter(sum->sum>0)
                .orElse(-1);
    }


}
