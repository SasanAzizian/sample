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
public class StringTest {
    public  static void main(String[] args){
        String s=(replace("SASAn Azizian", 'A', 'P'));
        
        
    }
    
    public static String replace(String str, char c, char r){
        if(str=="")
            return "not valid";
        char[] word=str.toCharArray();
        for(int i=0;i<str.length();++i){
            if(word[i]==c)
                word[i]=r;
                
        }
        
        
        return new String(word);
    }
}
