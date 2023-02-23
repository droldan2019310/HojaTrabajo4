package Factory;

import interfaces.IStack;
import stacks.StackArray;
import stacks.StackListDouble;
import stacks.StackListSimple;
import stacks.stackArrayList;

public class StackFactory<T>{

    /**
     * create stack depends of param stack
     * @param stack
     * @return
     */
    public IStack<T> createStack(String stack){
        switch (stack) {
            case "ARRAY":
                return new StackArray<T>();
            case "ARRAYLIST":
                return new stackArrayList<T>();
            case "DOUBLE":
                return new StackListDouble<T>();
            case "LIST":
                return new StackListSimple<T>();
            default:
                return null;
        }
    }

}
