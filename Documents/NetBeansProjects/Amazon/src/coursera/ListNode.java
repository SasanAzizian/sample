/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera;

/**
 *
 * @author sazizian
 */
public class ListNode<E> {
    E data;
    ListNode<E> next;
    ListNode<E> prev;

    public ListNode(E data) {
        this.data = data;
    }
//    public E add(E element){
//        if(element==null)
//            throw new NullPointerException("Object can not be null");
//        
//        return element;
//    }
    
}
