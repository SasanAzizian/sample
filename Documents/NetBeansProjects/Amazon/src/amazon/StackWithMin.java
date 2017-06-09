/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon;

import java.util.*;

/**
 *
 * @author sazizian
 */
public class StackWithMin extends Stack<Integer> {
    Stack<Integer> min;

    public StackWithMin() {
        min=new Stack<Integer>();
    }
    
    public void push(int value){
        if(minValue()<value)
            min.push(value);
        super.push(value);  
  
    }
    public Integer pop(){
        int value=super.pop();
        if (value== minValue())
            min.pop();
        return value;
    }
    public int minValue(){
        if(min.isEmpty())
            return Integer.MIN_VALUE;
        return min.peek();
    }
    
    
    
}
