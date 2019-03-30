package com.moataz.counter.utils;


import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=", commandDescription = "This Command used for printing" +
        " out a series of numbers to the console in order")
public class CountingCommandParams {
    @Parameter(names = "--startValue", description = "Counting start value",
            validateWith = IsIntegerValidator.class)
    private int startValue;
    @Parameter(names = "--endValue", description = "Counting end value", validateWith = IsIntegerValidator.class)
    private int endValue;

    @Parameter(names = {"--i", "--interactive"})
    private boolean interactiveFlag;

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public boolean isInteractiveFlag() {
        return interactiveFlag;
    }

    public void setInteractiveFlag(boolean interactiveFlag) {
        this.interactiveFlag = interactiveFlag;
    }
}
