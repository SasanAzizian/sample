/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package udemy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sazizian
 */
public class ArrayTest {
    private Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        int[] myIntArray=new int[10];

        }
        
  public int[] getIntegers(int cap){
      int[] array=new int[cap];
      System.out.println("Enter "+cap+"integer value:\r");
      for(int i=0;i<array.length;++i){
          array[i]=s.nextInt();
      }
      return array;
  }
  
  public static void printArray(int[] array){
      for(int i=0;i<array.length;++i){
          System.out.println("Element "+i+" contents "+array[i]);
      }
  }
  
 
      
  }

