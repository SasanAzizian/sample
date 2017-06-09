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
public class SortStack<T extends Comparable> {
    Stack<T> sort;
    Stack<T> temp;

    public SortStack() {
        sort=new Stack<T>();
        temp=new Stack<T>();
    }
    
    public void sort(T value){
        if(!sort.isEmpty())
            sort.push(value);
        else{
            while(value.compareTo(sort.peek())>0){
              temp.push(sort.pop());
            } 
            sort.push(value);
            while(!temp.isEmpty()){
                sort.push(temp.pop());
            }
        }
    }
    
    
    
}
