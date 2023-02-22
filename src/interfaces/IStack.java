package interfaces;

public interface IStack<T> {
    public void push(T item);
    // pre: 
    // post: item is added to stack
    // will be popped next if no intervening push
    
    public T pop();
    // pre: stack is not empty
    // post: most recently pushed item is removed and returned
    
    public T peek();
    // post: returns true if and only if the stack is empty
    
    public int size();
    // post: returns the number of elements in the stack
 
}
