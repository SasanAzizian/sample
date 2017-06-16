/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LinkedLists;

import java.util.*;

/**
 *
 * @author sazizian
 */
public class RemoveDuplicate {
    
    public static void main(String[] args){
        LinkedList<Integer> l=new LinkedList<>();
        

       
       Node<Integer> n=new Node<>(0);
       Node<Integer> n1=new Node<>(1);
       Node<Integer> n2=new Node<>(2);
       Node<Integer> n3=new Node<>(1);
     
       
       Node<Integer> n4=new Node<>(0);
       Node<Integer> n5=new Node<>(9);
       Node<Integer> n6=new Node<>(2);
       Node<Integer> n7=new Node<>(null);
       n.next=n1;
       n1.next=n2;
       n2.next=n3;
       n3.next=n4;
//       n4.next=n5;
//       n5.next=n6;
//       n6.next=n7;
      //  Node<Integer> m=   palindromeLinkedLIst(n);
        System.out.println( palindromeLinkedLIst(n));
//       while(m.data!=null){
//           System.out.print(m.data);
//           m=m.next;
//       }
            
     
//            System.out.println(n);
//            System.out.println(m);
       //n2.next=n3;
       
 
    }
    private static <E> void removeDups2(Node<E> n){
        HashSet<Integer> set=new HashSet<>();
        while(n!=null){
            if(!set.contains(n.data)){
                set.add((Integer) n.data);
                
            }
            n=n.next;
        }
        display(set);
    }
    
    private static <T>  void removeDups(LinkedList<T> n){
        HashSet<T> set=new HashSet<>();
        while(!n.isEmpty()){
        //    System.out.println(n);
            if(!set.contains(n.element())){
                System.out.println(n.element());
                set.add((T) n.element());
            }           
            n.poll();
        }
        display(set);
    }
    private static <E> void display(Collection<E> c){
        Iterator<E> it=c.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        
    }
    
    private static <E extends Comparable<E>> Node<E> returnKthToLast(Node<E> n, E k){
	Node<E> result=null;
	if(n.data.compareTo(k)==0)
		return n;
	else{
		while(n.data!=k && n!=null){
			if(n.next.data==k){
                           
				  return result=n.next;
			}
			n=n.next;
		}
	}
       
	return result;
}
    
    public static <E> Node<E> deleteMidNode(Node<E> n){
	int len=0;
        Node<E> cur=n;
       
	while(cur!=null){
		cur=cur.next;
		++len;
	}
        int med=len/2;
        for(int i=0;i<len-1;++i){
            if(i==med){
                n=n.next;
            }else{
                n=n.next;
            }
        }
	
	
	
	return n;
}
    
private static Node<Integer> sumList(Node<Integer> a, Node<Integer> b){
	Node<Integer> result=new Node<>(null);
        Node<Integer> res=result;
        Node<Integer> result2=new Node<>(null);
         Node<Integer> res2=result2;
        int len=0;
	int carray=0;
	while(a.data !=null ){		
		carray=a.data+b.data+carray;
            //    System.out.println(carray);
		if(carray>10){
                        int c=carray%10;
             //           System.out.println(c);
                         result.data=c;
			carray=carray/10;
		}else{
			result.data=carray;
			carray=0;
		}
		a=a.next;
		b=b.next;
                System.out.println(result.data);
               result.next=new Node<Integer>(null);
               result=result.next;
                ++len;
                
	}
        System.out.println(len);
        int [] re=new int[len];
        int i=0;
        while (res.data!=null){
            //ystem.out.println(res.data);
          
            re[i]=res.data;
            res=res.next;
            ++i;
        }
        for(int j=re.length-1; j>-1;--j){
           // System.out.println(re[j]);
            result2.data=re[j];
            result2.next=new Node<Integer>(null);
            result2=result2.next;
            
        }
	return res2;
}

public static <E> boolean palindromeLinkedLIst(Node<E> node){
	Node<E> n=reverceLinked(node);
	boolean f=isEqual(node, n);
	return f;
}
private static <E> Node<E> reverceLinked(Node<E> n){
	Node<E> head=null;
	while(n!=null){
		Node<E> h=new Node<E>(n.data);
		h.next=head;
		head=h;
                n=n.next;
	}
	return head;
}
private static <E> boolean isEqual(Node<E> one, Node<E> two){
	while(one !=null && two !=null){
	if(one.data!=two.data)
		return false;
	one=one.next;
	two=two.next;
	}
	return true;
	
}
}
