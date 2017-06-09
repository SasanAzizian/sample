/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon;

import java.util.Stack;

/**
 *
 * @author sazizian
 */
public class MyQueue<T> {
    Stack<T> stackOldest;
    Stack<T> stackNesest;

    public MyQueue() {
        this.stackOldest = new Stack<>();
        this.stackNesest = new Stack<>();
    }
    public void puch(T value){
        stackNesest.push(value);
    }
    public T pop(){
        shiftStack();
        return stackOldest.pop();
    }
    
    public void shiftStack(){
        if(stackOldest.isEmpty()){
            while(!stackNesest.isEmpty()){
                stackOldest.push(stackNesest.pop());
            }
        }
    }
    public T peek(){
        shiftStack();
        return stackOldest.peek();
    }
    
}
