package models;

import interfaces.ICalculator;

public class Calculator implements ICalculator{

    @Override
    public float add(float a, float b) {
        // TODO Auto-generated method stub
        float result = a+b;
        return result;
    }

    @Override
    public float subtraction(float a, float b) {
        // TODO Auto-generated method stub
        float result = a-b;
        return result;
    }

    @Override
    public float multiplication(float a, float b) {
        // TODO Auto-generated method stub
        float result = a*b;
        return result;
    }

    @Override
    public float division(float a, float b) {
        // TODO Auto-generated method stub
        float result = a/b;
        return result;
    }

    @Override
    public void getNextImput() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextImput'");
    }
    
}
