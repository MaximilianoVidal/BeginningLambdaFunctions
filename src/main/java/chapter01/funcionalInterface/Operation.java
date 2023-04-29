package chapter01.funcionalInterface;
@FunctionalInterface
public interface Operation {
    // to the functional interface work it needs to have only ONE
    // abstract method

    float operation();

    private void interfacePrivateMethod(){
        System.out.println("Calling the private method of one interface");
        interfaceStaticMethod();
    }
    static void interfaceStaticMethod(){
        System.out.println("calling the static method of one interface");
    }
    default void interfaceDefaultMethod(){
        interfacePrivateMethod();
        interfaceStaticMethod();
        System.out.println("calling al method default de una interface");
    }
}
