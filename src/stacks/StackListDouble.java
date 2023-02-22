package stacks;

import Lists.DoubleLinkedList;
import interfaces.IStack;

public class StackListDouble<T> implements IStack<T> {
    DoubleLinkedList<T> doubleList  = new DoubleLinkedList<T>();

    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        doubleList.addLast(item);

    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        return doubleList.removeLast();
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return doubleList.topelement();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
