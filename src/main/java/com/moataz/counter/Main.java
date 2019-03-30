package com.moataz.counter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.moataz.counter.utils.CountingCommandParams;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            List<String> arguments = new ArrayList<>();
            Collections.addAll(arguments, args);
            if (arguments.contains("--i") || arguments.contains("--interactive")) {

                Scanner scanner = new Scanner(System.in);
                System.out.print("========================================= \n");
                System.out.print("========================================= \n");
                System.out.print("           Counter Tool            \n");
                System.out.print("========================================= \n");
                System.out.print("========================================= \n");

                System.out.print("Please Enter the start value: ");
                String startValue = scanner.next();
                arguments.add("--startValue");
                arguments.add(startValue);
                System.out.print("Please Enter the end value: ");
                String endValue = scanner.next();
                arguments.add("--endValue");
                arguments.add(endValue);
            }


            CountingCommandParams countingCommandParams = new CountingCommandParams();
            JCommander.newBuilder()
                    .addObject(countingCommandParams)
                    .build()
                    .parse(arguments.toArray(new String[0]));

            if (countingCommandParams.getStartValue() > countingCommandParams.getEndValue()) {
                throw new ParameterException("Start Parameter Cannot be Greater Than End Parameter");

            }
            Timer t = new Timer();
            CounterTask counterTask = new CounterTask(countingCommandParams.getStartValue(), countingCommandParams.getEndValue(), t);
            t.scheduleAtFixedRate(counterTask, 2000, 1000);
        } catch (ParameterException exception) {
            System.out.print(exception.getMessage());
            System.exit(1);
        }
    }
}
