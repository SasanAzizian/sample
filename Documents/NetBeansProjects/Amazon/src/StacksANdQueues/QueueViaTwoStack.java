/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksANdQueues;

import java.util.*;

/**
 *
 * @author sazizian
 */
public class QueueViaTwoStack<T> {

    Stack<T> newStack = new Stack<>();
    Stack<T> oldStack = new Stack<>();

    public void add(T item) {
        newStack.push(item);
    }

    public  T remove() {
        T t = null;
        if (!oldStack.isEmpty()) {
            t = (T)oldStack.pop();
        } else {
            while (newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
            t = (T)oldStack.pop();

        }
        return t;
    }

}
