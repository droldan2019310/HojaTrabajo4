package stacks;

import java.util.ArrayList;

import interfaces.IStack;

public class stackArrayList<T> implements IStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();
    int position=-1;


    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        stack.add(item);
        position++;
    }

    @Override
    public T pop() {
        T a = stack.get(position);
        stack.remove(position);
        position--;
        return a;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return stack.get(position);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
