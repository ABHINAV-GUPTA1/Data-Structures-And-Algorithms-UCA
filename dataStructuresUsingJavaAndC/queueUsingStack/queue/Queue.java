package queue;

import java.util.Stack;

/** Queue implementation using
 * 
 * */
public class Queue<E>{
    Stack<E> s1,s2;
    Queue(){
        s1 = new Stack<E>();
        s2 = new Stack<E>();
    }
    public void enqueue(E data) {
        s1.push(data);
    }
    public void dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) 
                s2.push(s1.pop());
        }
        s2.pop();
    }
    public E peek(){
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) 
                s2.push(s1.pop());
        }
        return s2.peek();
    }
}