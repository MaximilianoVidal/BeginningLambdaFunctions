package chapter01.funcionalInterface;




//to use an interface you need to implemet it at the start of the class
public class MainExample implements Operation{
    public static void main(String[] args) {
        new MainExample();
    }

    public MainExample(){
       /*
        Operation.interfaceStaticMethod();
        interfaceDefaultMethod();
       */
        // calls the interfaz and creates a new anonymous class inside the call
        Operation o1= multiplication();
        // this example Operation o2=()->o1.operation(); can also be
        Operation o2 = o1::operation;// this is a lambda expression
        printResultOfThis(o2);
        // When you establish the parameter
        printResultOfThis(MainExample::anyMethod);
    }

    private Operation multiplication() {
        return new Operation() {// anonymous class
            @Override
            public float operation() {
                //the final letter in the equal value of the var define his type
                var value1 = 3.3f;
                print("primer valor: " + value1);
                var value2 = 3;
                print("Segundo valor: " + value2);
                return value1 * value2;
            }

            private void print(String value) {
                System.out.println(value);
            }
        };
    }
    private static float anyMethod(){
        return 2/5;
    }



    private void printResultOfThis(Operation operation){
        System.out.println(operation.operation());
    }

    @Override
    public float operation() {
        return 0;
    }

    @Override
    public void interfaceDefaultMethod() {
        Operation.super.interfaceDefaultMethod();
    }
}
