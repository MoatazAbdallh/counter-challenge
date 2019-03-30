package com.moataz.counter.utils;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class IsIntegerValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException nfe) {
            throw new ParameterException("Invalid Input; Only Integers Allowed");
        }
    }
}
