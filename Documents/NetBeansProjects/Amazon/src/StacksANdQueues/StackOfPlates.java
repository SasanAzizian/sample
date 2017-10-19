/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StacksANdQueues;
import java.util.*;

public class StackOfPlates extends Stack<Integer>{
	ArrayList<Stack<Integer>> array=new ArrayList<>();
	int max=100;
	
	
	public void push(int a){
		if(array.get(size()-1).size()<(max)){
			array.get(size()-1).push(a);
		}else{
			array.add(new Stack<Integer>());
			array.get(size()-1).push(a);
			
		}
	}
	public Integer pop(){
		if(array.get(size()-1).isEmpty()){
			array.remove(size()-1);
			return array.get(size()-1).pop();
		}else{
			return array.get(size()-1).pop();
		}
	}
	
}