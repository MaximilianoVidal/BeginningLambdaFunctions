package chapter01.funcionalInterface.funcionalInterface;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        var string = "i'm so lost";
        var instance = new MethodReference();
        Supplier<String> instanceMethod = string::toUpperCase;
        // method get called by reference method
        Supplier<String> instanceMethod2= instance::get;
        Supplier<String> instanceMethod3= instance::getReferenceMethod;

        Supplier<MethodReference> constructorReference=MethodReference::new;
        Predicate<String> staticMethod = Objects::isNull;//objets compare two values and return a boolean

        // .get to receive the value of the instance.-> anything
        System.out.println(instanceMethod.get());
        System.out.println(instanceMethod2.get());
        System.out.println(instanceMethod3.get());
        System.out.println(constructorReference.get().toString());
        System.out.println(staticMethod.test(null));
// test its equal to get. Test is used for predicate method

    }
    public String getReferenceMethod(){
        // create a supplier string method, who receive the get method
        Supplier<String> supplier = this::get;
        // and then concat two of them in this case: "anything" with call it with this<-.
        return supplier.get().concat("-> call it with 'this'");
    }
    public String get(){
        return "anything";
    }
    public String toString(){
        return "im an instance";
    }


}
