/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon;

import java.awt.BorderLayout;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author sasan
 */
public class BinaryHEap {


    public static void main(String[] args) {
        int[] a = {1, 10, 5, -3, 4, 7, 6, 9, 18, -5};
        int[] b = {1, 3, 5, 8, 9, 11, 13, 15, 16, 19, 20, 21};
        String[] c={"cat", "tac", "pot", "top", "meow", "act" };
        Stack<Integer> s=new Stack<>();
        s.push(5); s.push(8);s.push(10);s.push(4);s.push(6);s.push(2);
        s.push(17);s.push(1);
      //  sortStack(s);
        System.out.println(sameWord(c));

    }

    private static int findSmalestK(int[] array, int k) {

        if (k < 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; ++i) {
            pq.add(array[i]);
        }

        for (int j = k; j < array.length; ++j) {
            if (array[j] < pq.peek()) {
                pq.remove();
                pq.add(array[j]);
            }
        }
        return pq.peek();
    }

    //Given two words, find if second word is the round rotation of first word.
    private static boolean checkRotation(String w1, String w2) {
        int len = w1.length();
        if (len > 0 && len == w2.length()) {
            String W1 = w1 + w1;
            if (W1.contains(w2)) {
                return true;
            }

        }

        return false;
    }

    //Given a string of words return all words which have their reverse present in the string as 
    //( (word1 , reverseword1 ) , (word2 ,reverseword2) )
    private static String checkReverce(String s) {
        // System.out.println(reverce("sasan Azizian"));

        if (s.length() < 1 || s == null) {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(BinaryHEap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String[] array = s.split(" +");
        StringBuffer result = null;
        for (String word : array) {
            System.out.print("(" + word + " ," + reverce(word) + " ) ,");

        }
        return result.toString();
    }

    private static String reverce(String s) {

        if (s == null || s.length() < 1) {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(BinaryHEap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        char[] array = s.toCharArray();
        char[] newArray = new char[array.length];

        int j = array.length;
        for (int i = 0; i < array.length; ++i) {
            newArray[i] = array[array.length - i - 1];

        }
        return new String(newArray);
    }

//Finding the just smaller number formed using same number of digits.
//   Print -1 if not possible
    private static int findSmallest(int number) {
        char[] n = Integer.toString(number).toCharArray();

        Arrays.sort(n);
        System.out.println(n);
        StringBuilder result = new StringBuilder();
        for (int i = n.length - 1; i > -1; --i) {
            result.append(n[i]);
        }
        return Integer.parseInt(result.toString());
    }

//In an array find two numbers whose sum equals zero in O(n) complexity
    private static int checkSum(int[] number) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : number) {
            map.put(n, n);
        }
        for (int i = 0; i < number.length; ++i) {
            // System.out.println(map.get(number[i]));
            if ((map.containsKey(-map.get(number[i])))) {
                return map.get(number[i]);
            }
        }

        return -1;
    }

//Given an array of number in sorted order count the pair of number whose sum is less than X.
    private static int checkSumX(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        int count = 0;
        while (l < r) {
            if ((a[l] + a[r]) < x) {
                count += (r - l);
                ++l;
            } else {
                r--;
            }
        }
        return count;
    }
    
    
//Given an range of number count the numbers which has same first and last digits.
//    For e.g. start =7 and End =95 so the numbers are 7,8,9,11,22,33,44,55,66,77,8
    private static int checkSameNumber(int first, int end) {
        int count = 0;
        for (int i = first; i <= end; ++i) {
            if (String.valueOf(i).length() == 1) {
                ++count;
                System.out.println(i);
            } else {
                char[] c = String.valueOf(i).toCharArray();
                if (c[0] == c[c.length - 1]) {
                    ++count;
                    System.out.println(i);
                }
            }

        }
        return count;
    }

//: Write a program to determine whether a given number can be expressed as sum of two prime numbers or not.
    private static boolean checkForSumofTwoPrimeNumber(int n) {
        for (int i = 2; i <= n / 2; ++i) {
            if (i + (n - i) == n) {
                if (isPrime(i) & isPrime(n - i)) {
                    System.out.println(i + " + " + (n - i) + " = " + n);
                }
            }
        }
        return true;
    }
//calculate Prime Number
    private static boolean isPrime(int n) {

        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    //Palindrome : n+inverse(n)=Palindrom, 15+51=66
    private static int checkPalindrome(int n) {
        if (n == 0 || n < 10) {
            return -1;
        }
        int result = n + reverceNumber(n);
        char[] array = String.valueOf(result).toCharArray();
        if (array[0] == array[array.length - 1]) {
            System.out.println("This numbe is Palindrome=" + result);
        } else {
            System.out.println("NO");
        }
        return result;
    }

    private static int reverceNumber(int n) {
        int result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }
        return result;
    }

    //Find the max number in an array between start and end. The function would like:
    private static int findMaxBetween(int[] a, int start, int end) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(end - start, Collections.reverseOrder());
        for (int i = start; i <= end; ++i) {
            pq.add(a[i]);
        }
        return pq.peek();

    }

//'Find the longest unbroken series of increasing numbers in a list of random numbers',
//i.e. if given [15, 2, 38, 71, 2, 524, 98], return [2, 38, 71] 
    private static String randomIncresing(int[] a) {
        StringBuilder max = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < a.length - 1; ++i) {

            if (a[i] < a[i + 1]) {
                max.append(a[i] + ", ");
                ++count;
            } else {
                max.append(a[i] + ", ");
                ++count;
                if (count >= maxCount) {
                    maxCount = count;
                    result = max;
                    max = new StringBuilder();
                    count = 0;
                }

            }
        }
        return result.toString() + "  " + String.valueOf(maxCount);

    }

//16) Write a function that returns true if a string of parentheses is balanced or not,
//    such as "(())()", which would return true.  static 
    private static boolean checkBalanceParentheses(String s) {
        if (s == "" || s == null || s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if(stack.isEmpty())
                    try {
                        throw new IllegalAccessException();
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BinaryHEap.class.getName()).log(Level.SEVERE, null, ex);
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
//17) Given an input stream of strings, find the most frequent string
    private static String checkMostFrequentString(String stream){
        String[] s=stream.split(" +");
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        String maxString="";
        int maxInt=0;
        for(String word:s){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        for(String word:s){
     
            if(map.get(word)>maxInt){
                maxInt=map.get(word);
                maxString=word;
                System.out.println(maxInt+"  "+maxString);
            }
                
        }
        return maxString;
    }
    
//19) Given an array input of N number of strings. [ cat, tac, pot, top, meow, act ]
//Return the output : [[act,cat,act], [pot,top], [meow]]  
    private static String sameWord(String[] array){
        String result="";
        if(array.length<1)
            return "Nothing";
        HashMap<String, String> map=new HashMap<String, String>();
        for(String s:array){
           char[] ch=s.toCharArray();
           Arrays.sort(ch); 
           String newCH=new String(ch);   
          
           if(map.containsKey(newCH)){
               map.put(newCH, map.get(newCH)+", "+ s);               
           }else
               map.put(newCH, s);
        }
       
        Set entry=map.entrySet();
        Iterator itr=entry.iterator();
        while(itr.hasNext()){
            Map.Entry mapping = (Map.Entry)itr.next();
            result += "["+mapping.getValue().toString()+"] ,";
        }
        return result;
    }
    
//BOOK #4 Permitution of Palindrome
    private static boolean permutationOfPalindrom(String s){
        char[] array=s.toCharArray();
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        int countOdd=0;
        for(int i=0;i<array.length;++i){
            if(array[i]!=' ')    
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }else
                map.put(array[i],1);
        }
        Set entity=map.entrySet();
        Iterator it=entity.iterator();
        while(it.hasNext()){
            Map.Entry m=(Map.Entry)it.next();
             System.out.println(m.getKey()+"   " + m.getValue());
            if((Integer)m.getValue()%2 != 0){
                ++countOdd;
               
            }
        }
        return (countOdd<2);
    }
    
//Book #3 URLify
    private static String replaceSpace(String s){
        if(s.length()<1)
            return "Error";
        System.out.println(s.length());
        int count=0;
        for(int i=0; i<s.length();++i){
            ++count;
            if(s.charAt(i)==' ')
                count+=2;
        }
        
        char[] array=new char[count];       
        int len=array.length;
        for(int i=s.length()-1;i>=0;--i){
            if(s.charAt(i)==' '){
                array[--len]='0';
                array[--len]='2';
                array[--len]='%';
               
            }else{
                array[--len]=s.charAt(i);
            }            
        }
        return new String(array);
    } 
    
 // Book #5 One Way
    private static boolean oneEditAway(String first, String second){
        int index1=0;
        int index2=0;
        boolean f=false;
        while(index1<first.length() && index2<second.length()){
            if(first.charAt(index1)== second.charAt(index2)){
                ++index1; ++index2;
            }else{
                if(f)
                    return false;
                if(first.length()>second.length())
                    ++index1;
                else if(first.length()<second.length())
                    ++index2;
                else{
                    ++index1; ++index2;
                }
                f=true;
            }
        }
        
        return true;
    }
    
    private static String compressBAd(String str){
        StringBuilder newStr=new StringBuilder();
        int count =1;
        for(int i=0;i<str.length()-1;++i){
            if(str.charAt(i)== str.charAt(i+1)){
                ++count;
                if(i+1==str.length()-1)
                    newStr.append(str.charAt(i)).append(count);
            }
               
            else{
                
                 newStr.append(str.charAt(i)).append(count);
                 count=1;
            }
           
        }
        
        return newStr.toString().length()<str.length()? newStr.toString() : str;
    }
    
    //Bit MAnupulation
    private static boolean getBit(int num, int i){
        return((num & (1<<i))!=0);
    }
    
    private static void sortStack(Stack<Integer> s)                                                                                                                               {
        Stack<Integer> temp=new Stack<>();
        while(!s.isEmpty()){
            int item=s.pop();
            while(!temp.isEmpty() && item<temp.peek()){
                s.push(temp.pop());
            }
            temp.push(item);
        }
        while(!temp.isEmpty()){
            int i=temp.pop();
            System.out.print(i+", ");
            s.push(i);
        }
    }
}
