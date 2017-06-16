/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LinkedLists;

/**
 *
 * @author sazizian
 */
public class MyLinkList<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkList() {
        size=0;
        head=new Node<E>(null);
        head.next=tail;
        tail=new Node<E>(null);
        tail.prev=head;
    }
    
    
}
