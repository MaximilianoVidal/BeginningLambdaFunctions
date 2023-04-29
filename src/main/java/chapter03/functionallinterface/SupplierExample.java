package chapter03.functionallinterface;
//Supplier
import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

        Supplier<LocalDate> date= LocalDate::now;
        var random = new Random();
        Supplier<Integer> randomIt= random::nextInt;
        Supplier<HotDog> hotdog =HotDog::new;
        usingSupplier(date);
        usingSupplier(randomIt);
        usingSupplier(randomIt);
        usingSupplier(date);
        usingSupplier(hotdog);

    }

    static <T> void usingSupplier(Supplier<T> supplier){
        System.out.println("Hello world");
        System.out.println(" gets: "+supplier.get());
    }

}
