package Lists;

import java.util.NoSuchElementException;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
 
    public DoubleLinkedList() {
        size = 0;
    }

    public int size() {
    	return size; 
    }     
 
    public boolean isEmpty() {
    	return size == 0; 
    }
 
    public void addFirst(T element) {
        Node<T> tmp = new Node<T>(element, head, null);
        if(head != null ) {
        	head.prev = tmp;
        }
        head = tmp;
        if(tail == null) {
        	tail = tmp;
       }
        size++;
    }
 
    public void addLast(T element) {         
        Node<T> tmp = new Node<T>(element, null, tail);
        if(tail != null) {
        	tail.next = tmp;
        }
        tail = tmp;
        if(head == null) {
        	head = tmp;
        }
        size++;
    }
 
    public void iterateForward(){         
        Node<T> tmp = head;
        while(tmp != null){
            tmp = tmp.next;
        }
    }
 
 
    public void iterateBackward(){         
        System.out.println("Iterating backword.");
        Node<T> tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }
 
    public T removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node<T> tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp.element;
    }
 
    public T removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node<T> tmp = tail;
        tail = tail.prev;
        size--;
        return tmp.element;
    }

    

    
    public T topelement(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        else{
            return tail.element;
        }
    }
}
