package org.codecop.lcdnumbers;

import java.util.Arrays;
import java.util.List;

public class Main {

    private LcdDisplay lcdDisplay;

    public Main() {
        lcdDisplay = new LcdDisplayImpl();
    }


    public void doRun(List<String> nonOptionArgs) {
        if (nonOptionArgs.size() == 0) {
            System.out.println("Run this class to see LCD Numbers working:");
            System.out.println("\nRunning the generated jar:");
            System.out.println("java -jar target/lcd-numbers-di-framework-kata-1.0.0-SNAPSHOT.jar 12345 2");
            System.out.println("\nRunning via Maven:");
            System.out.println("mvnw spring-boot:run -Dspring-boot.run.arguments=12345,2");
            return;
        }

        int number = Integer.parseInt(nonOptionArgs.get(0));

        ScalingArgument scalingArgument = new ScalingArgument(nonOptionArgs);
        System.out.print(lcdDisplay.toLcd(number, scalingArgument.getScaling()));
    }

    public static void main(String[] args) {
        new Main().doRun(Arrays.asList(args));
    }

}
