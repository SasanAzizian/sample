/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera;

import java.util.LinkedList;

/**
 *
 * @author sazizian
 */
public class MyLinkedList<E> {
    
    private ListNode<E> head;
    private ListNode<E>  tail;
    private int size;

    public MyLinkedList() {
        this.head = new ListNode<E>(null);
        head.next=tail;       
                
        this.tail = new ListNode<E>(null);
        tail.prev=head;
        
        this.size = 0;
    }
    
    
   
}
