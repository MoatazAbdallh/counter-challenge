package com.moataz.counter;

import java.util.Timer;
import java.util.TimerTask;

public class CounterTask extends TimerTask {
    private int currentValue;
    private int endValue;
    private Timer timer;

    public CounterTask(int startValue, int endValue, Timer timer) {
        currentValue = startValue;
        this.endValue = endValue;
        this.timer = timer;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    @Override
    public void run() {
        System.out.print(currentValue + "\n");

        if (currentValue % 3 == 0 && currentValue % 5 == 0) {
            System.out.print("fooboo\n");
        } else {
            if (currentValue % 3 == 0) {
                System.out.print("foo\n");
            }
            if (currentValue % 5 == 0) {
                System.out.print("boo\n");
            }
        }
        currentValue++;
        if (currentValue > endValue) {
            timer.cancel();
        }
    }
}
