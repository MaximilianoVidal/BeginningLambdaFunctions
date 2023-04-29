package logger;

import org.testng.log4testng.Logger;

public class Main {
   private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("hello");
        System.out.println("hi");

    }
}
