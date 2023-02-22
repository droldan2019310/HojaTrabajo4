package stacks;

import interfaces.IStack;

public class StackArray<T>  implements IStack<T> {
    T[] array;
    int position=0;

    public StackArray(){
        array =  (T[]) new Object[20];
    }
    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        if(position<20){
            array[position] = item;
            position++;
        }else{
            System.out.println("CADENA DEMASIADO GRANDE");
        }
        
    }

    @Override
    public T pop() {
        position--;
        T a = array[position];
        return a;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return array[position-1];
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
