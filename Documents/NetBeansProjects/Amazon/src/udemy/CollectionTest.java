/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

/**
 *
 * @author sazizian
 */
public class CollectionTest {

   

    public static void main(String[] args) {
 
        System.out.println(test());
        

    }
    
    public static int  test(){
         List<Seat> seats = new ArrayList<>();
               Seat s1 = new Seat("A1");
        Seat s2 = new Seat("A2");
        Seat s3 = new Seat("A3");
        Seat s4 = new Seat("A4");
        Seat s5 = new Seat("A5");
        seats.add(s1);
        seats.add(s2);
        seats.add(s3);
        seats.add(s4);
        
        int foundSeat=Collections.binarySearch(seats, s2.getSeatNumber(), null);
        return foundSeat;
    }
    
    

}
