/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayString;

/**
 *
 * @author sazizian
 */
import java.util.*;

public class IsUnique {

    public static void main(String[] args) {
        int[][] b={{1,2,0},{3,4,34},{0,6,43}};
        int[][] d=RotateMatrix(b);
        for(int i=0;i<d.length;++i){
            for(int j=0; j<d[0].length;++j)
                System.out.print(d[i][j]+"  ");
            System.out.println("");
            }
        System.out.println(RotateMatrix(b));
//        int a = 'A';
//        System.out.println(a + "  " + Character.getNumericValue(a));

    }

    private static boolean IsUnique(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ') {
                if (map.containsKey(str.charAt(i))) {
                    return false;
                } else {
                    map.put(str.charAt(i), 1);
                }
            }
        }
        return true;
    }

    private static boolean ISUniqe2(String str) {
        boolean[] array = new boolean[128];
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ') {
                int ch = str.charAt(i);
                if (array[ch]) {
                    return false;
                } else {
                    array[ch] = true;
                }
            }
        }
        return true;
    }

    private static boolean checkPermutation(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch2);
        if (ch1.length != ch2.length) {
            return false;
        } else {
            for (int i = 0; i < ch1.length; ++i) {
                if (ch1[i] != ch2[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static String URLift(String str) {
        StringBuilder sb = new StringBuilder();
        String[] words = str.split(" +");
        for (int i = 0; i < words.length; ++i) {
            if (i != words.length - 1) {
                sb.append(words[i]).append("%20");
            } else {
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }

    private static boolean PalindromePermutation(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) != ' ') {
                if (!map.containsKey(str1.charAt(i))) {
                    map.put(str1.charAt(i), 1);
                } else {
                    map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
                }

            }
        }
        int odd = 0;
        for (int i = 0; i < str2.length(); ++i) {
            if (str1.charAt(i) != ' ') {
                if (!map.containsKey(str2.charAt(i))) {
                    return false;
                } else {
                    if (map.get(str2.charAt(i)) % 2 != 0) {
                        ++odd;
                    }
                }
            }
        }
        return odd == 1;

    }

    private static boolean OneWay(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            throw new IllegalArgumentException();
        }
        int len = 0;
        int j = 0;
        boolean flage = false;
        boolean eq = false;
        if (str1.length() == str2.length()) {
            eq = true;
        }
        len = (str1.length() > str2.length()) ? str1.length() : str2.length();
        for (int i = 0; i < len; ++i) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (flage) {
                    return false;
                }
                flage = true;

            } else {
                if (j < str1.length() - 1 && j < str2.length() - 1 && !eq) {
                    ++j;
                }
            }
            if (eq) {
                ++j;
            }
        }
        return true;
    }

    private static String compression(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                ++count;
            } else {
                sb.append(str.charAt(i)).append(count);
                count = 0;
            }
        }
        if (count == 0) {
            sb.append(str.charAt(str.length() - 1));
        } else {
            sb.append(str.charAt(str.length() - 1)).append(count);
        }       
        if(str.length()<sb.toString().length())
            return str;
        else
            return sb.toString();

 

    }
    
    public static int[][] RotateMatrix(int[][] a){
	boolean[] row=new boolean[a.length];
	boolean[] col=new boolean[a[0].length];	
	for(int i=0;i<a.length;++i){
		for(int j=0;j<a[0].length;++j){
			if(a[i][j]==0){
				row[i]=true;
				col[j]=true;				
			}
		}		
	}    
	for(int i=0;i<a.length;++i){
		for(int j=0;j<a.length;++j){
                    if(row[i])
			a[i][j]=0;
		}
		for(int j=0;j<a.length;++j){
			if(col[i])
			a[j][i]=0;
		}
	}
	return a;
}
}
