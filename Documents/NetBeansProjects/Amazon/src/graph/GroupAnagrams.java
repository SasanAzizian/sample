/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Arrays;
import java.util.*;

/**
 *
 * @author sazizian
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] s = {"sasan", "nasas", "nsaas", "ansas", "sansa", "abc", "bca", "acb", "bac", "cab", "saman"};
        for(String ss:groupAnagram(s))
         System.out.println(ss);
    }

    public static String[] groupAnagram(String[] str) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        //    ArrayList<String> list=new ArrayList<>();
        for (String s : str) {
            String key = sort(s);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }else{
                map.get(key).add(s);
            }

        }
        int index=0;
        for (String key : map.keySet()) {
            ArrayList<String> l=map.get(key);
            for(String word:l){
                str[index]=word;
                ++index;
            }
           

        }
        return str;
    }

    private static String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

}
