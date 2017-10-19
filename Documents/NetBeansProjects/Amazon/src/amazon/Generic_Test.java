/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;



/**
 *
 * @author sazizian
 */
public class Generic_Test {
    
    public static <T extends Comparable <T>> int countGreaterThan(T[] list, T elm){
        
        int count =0;
        for(T t:list){
            if(elm.compareTo(t)>0)
                ++count;
        }
        return 1;
    }
    
    public static <E> void print(E[] list){
        
        for(E e:list){
            System.out.println(e+" ");
        }
    }
    
}
