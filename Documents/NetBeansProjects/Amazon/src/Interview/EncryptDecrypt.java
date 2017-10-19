package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Sasan Azizian
 */
public class EncryptDecrypt {

    // This is a cache 
    private HashMap<String, String> map = new HashMap<String, String>();

    // main program
    public static void main(String[] args) {
        EncryptDecrypt obj = new EncryptDecrypt();

        System.out.println("You can test Encryption method and Whenever you like to finesh this method please push '*', then you can test Decrytion Method ");
        System.out.println("");
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String item = s.next();
            if (item.equals("*")) {
                break;
            }
            obj.encrypte(item);
            System.out.println("");
        }

        System.out.println(" You can test the Decrytion Method");
        Scanner s2 = new Scanner(System.in);
        while (s2.hasNext()) {
            //      System.out.println("Enter the world that you want to Encripte it: ");
            String item = s2.next();
            if (item.equals("*")) {
                break;
            }

            obj.decrype(item);
            System.out.println("");
        }

    }
    /*  This method implements the algorithm :
     Split the name into two equal parts. if it is an odd number length, then add a # at the end of the name to make the length even.
		  Example: Amin -> “Am” “in”
		  Example: Vimal -> “Vim” “al#”
     o Reverse the parts and concatenate back into one string
		  Example: Amin -> Am in -> inAm
		  Example: Vimal -> Vim al# -> al#Vim
     o Decryption would reverse this algorithm and remove the ‘#’ symbol if present.
     */

    private String encryptionAlgorithm(String str) {
        {
            String first = null, second = null;

            if (str.length() == 0 || str.equals(null) || str == "") {
                return "Your string should NOT be Null";
            }
            if (str.length() % 2 == 0) {
                first = str.substring(0, (str.length() / 2));
                second = str.substring((str.length() / 2), str.length());

            } else {
                first = str.substring(0, (str.length() / 2) + 1);
                second = str.substring((str.length() / 2) + 1, str.length()) + "#";
            }
            map.put(str, second + first);
            System.out.println("adding to catche");
            return second + first;
        }

    }

    /*  This method Implements Encryption method:
     o If the non-encrypted name is in the cache, just return the encrypted name
     o Otherwise encrypt the name per the encryption algorithm, add to the cache, and return  the encrypted name        
     */
    private String encrypte(String str) {
        if (str.length() == 0 || str.equals(null) || str == "") {
            return "Your string should NOT be Null";
        }
        System.out.println("encrypting " + str);
        // check the cache to fine it
        if (map.containsKey(str)) {
            System.out.println(str + " found in cache");
            System.out.println("result = " + map.get(str));
        } else {
            // When the item does not in the cache, then according to the algorithem will add the item to cache
            String result = encryptionAlgorithm(str);
            System.out.println("result = " + result);
        }
        return "";
    }

    /*  This methos implemets Decryption method:
     o If the encrypted name is in the cache, return the non-encrypted name
     o Otherwise decrypt the name by reversing the encryption algorithm, add to the cache,and return the non-encrypted name
     */
    private String decrype(String str) {
        String str2 = str;
        if (str.length() == 0 || str.equals(null) || str == "") {
            return "Your string should NOT be Null";
        }
        System.out.println("decrypting " + str);
        // first check the lenght of string, if it was odd then it should chand to new format : EX: 123----> 1#23
        if (str.length() % 2 != 0) {
            str2 = str.substring(0, (str.length() / 2)) + "#" + str.substring((str.length() / 2), str.length());
        }
        // check the cahce for find the value
        if (map.containsValue(str2)) {
            System.out.println(str + " found in cache");
            System.out.println("result = " + getKeyByValue(map, str2));
        } else {
            System.out.println("result = " + encryptionAlgorithm(str));

        }
        return "";
    }
    /*
     For finding the key of the value in our cache we implemets this method.    */

    public String getKeyByValue(Map<String, String> map, String value) {
        for (Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
