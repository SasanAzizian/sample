/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StacksANdQueues;

import java.util.Stack;

/**
 *
 * @author sazizian
 */
public class StackMin extends Stack<Integer> {
    Stack<Integer> min;

    public StackMin() {
        min=new Stack<>();
    }
    public void push(int a){
        if(a<min.peek())
            min.push(a);
        super.push(a);
    }
    public Integer pop(){
        int p=super.pop();
        if(p==min.peek())
            min.pop();
        return p;
    }
    public Integer min(){
        return min.peek();
    }
    
    
}
