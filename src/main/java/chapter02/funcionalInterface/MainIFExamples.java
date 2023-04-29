package chapter02.funcionalInterface;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainIFExamples {
    public static void main(String[] args) {
        comparatorExample();
        // runnableExample();
        // callableExample();
        //actionListenerExample();
    }
// n°1 lambda expression
    private static void actionListenerExample(){
        var frame = new JFrame();
        //screen dimension
        frame.setSize(Toolkit.getDefaultToolkit()
                .getScreenSize());
        //button
        var btn = new JButton("EXIT");
        // set the size, in this case is the same
        btn.setSize(frame.getSize());
        out(btn);
        // adds to the content pane
        frame.getContentPane()
                .add(btn);
        // make it visible
        frame.setVisible(true);
    }
    private static void out(JButton btn) {
        btn.addActionListener(event->{
            System.out.println("saliendo...");
            System.exit(0);});
    }

// n°2 lambda expression
    private static void callableExample(){
        try{
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(MainIFExamples::operation);
            System.out.println(future.get());
            executor.shutdown();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
    private static String operation(){
        Character [] charArray = new Character[]{'I','m',' ','a',' ','C','h','a','i','n'};
        var bffer = new StringBuffer("recomponiendo cadena ->");
        Arrays.stream(charArray)
                .forEach(character -> {
                    System.out.println(character);
                    bffer.append(character);
                });
        System.out.println(Thread.currentThread()
                .getName());
        return bffer.toString();
    }

// n°3 lambda expression
    public static void runnableExample(){
        var thread = new Thread(MainIFExamples::runBehavior);
        thread.start();
    }
    public static void runBehavior(){
        var i= 0;
        while (i++ !=100){
            System.out.println("call to run() n°: "+i);
        }
    }

// n°4 lambda expression
    private static void comparatorExample(){
        // el (MainIFExamples::compare);-> se llama referencia a metodo
        var tree = new TreeSet<>(MainIFExamples::compare);
        tree.add(4);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(8);
        tree.add(1);
        // print in the console all htf do I call that lets just say numbers
        tree.forEach(System.out::println);
    }

    private static int compare(Integer a,Integer b){
        if (a<b) return 1;
        if (a.equals(b)){
            return 0;
        }
        return -1;
    }


}
