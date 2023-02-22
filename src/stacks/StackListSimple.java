package stacks;

import java.util.LinkedList;

import interfaces.IStack;

public class StackListSimple<T> implements IStack<T> {
    LinkedList<T> stack = new LinkedList<T>();
    
    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        stack.push(item);    

    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        
        return stack.pop();
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return stack.getFirst();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
