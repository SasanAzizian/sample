package udemy.test;

/**
 *
 * @author sazizian
 */
import java.io.*;
import java.util.*;

class Solution {

    static Map<String, ArrayList<String>> m1 = new HashMap<>();
    static Set<String> set_value = new HashSet<>();
    static Set<String> set_key = new HashSet<>();

    static List<List<String>> myList = new ArrayList<List<String>>();

    public static List<List<String>> create_workflow_stages(List<List<String>> precursor_steps) {
        // IMPLEMENTATION GOES HERE   

        for (int i = 0; i < precursor_steps.size(); ++i) {  
            String key = precursor_steps.get(i).get(0);
            String value = precursor_steps.get(i).get(1);            
            set_key.add(key);
            if (!m1.containsKey(key))
                m1.put(key, new ArrayList<String>());
            m1.get(key).add(value);
            set_value.add(value);           

        }

        Set<String> set_key_temp = new HashSet<>();
        set_key_temp.addAll(set_key);
        // find the root of the array
        set_key_temp.removeAll(set_value);
        ArrayList<String> find_root = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        find_root.addAll(set_key_temp);

        //add root 
        myList.add(find_root);
        for (int i = 0; i < find_root.size(); ++i) {
            ArrayList<String> str1 = m1.get(find_root.get(i));
            for (String s : str1) {
                if (!myList.contains(str1)) {
                    if (set_key.contains(s)) {
                        myList.add(m1.get(find_root.get(i)));
                        values.addAll(m1.get(find_root.get(i)));
                    }
                }
            }
        }

        Map<String, Integer> chile_Size = new LinkedHashMap<String, Integer>();
        while (values.size() > 0) {
            for (int i = 0; i < values.size(); ++i) {
                chile_Size.put(values.get(i), m1.get(values.get(i)).size());
            }
            values.clear();
            for (Map.Entry<String, Integer> item : chile_Size.entrySet()) {
                myList.add(m1.get(item.getKey()));
                if (set_key.contains(m1.get(item.getKey()))) {
                    values.addAll(m1.get(item.getKey()));
                }
            }

        }

        for (int j = 0; j < myList.size(); ++j) {
            System.out.println( myList.get(j));
        }
        set_key.clear();
        set_key_temp.clear();
        set_value.clear();
        m1.clear();

        return myList;
    }

    /* START TEST CASES
     * You can add test cases in the two lists below. Each test case
     * input/expected output should correspond to the same index in the
     * respective lists returned.
     */
    static List<List<List<String>>> testInputs = Arrays.asList(
            Arrays.asList(
                    Arrays.asList("clean", "build"),
                    Arrays.asList("metadata", "binary"),
                    Arrays.asList("build", "link"),
                    Arrays.asList("link", "binary"),
                    Arrays.asList("clean", "metadata"),
                    Arrays.asList("build", "resources")
            ),
            Arrays.asList(
                    Arrays.asList("boil", "serve"),
                    Arrays.asList("chop", "boil"),
                    Arrays.asList("stir", "boil"),
                    Arrays.asList("set table", "serve")
            )
    );

    static List<List<List<String>>> testOutputs = Arrays.asList(
            Arrays.asList(
                    Arrays.asList("clean"),
                    Arrays.asList("build", "metadata"),
                    Arrays.asList("resources", "link"),
                    Arrays.asList("binary")
            ),
            Arrays.asList(
                    Arrays.asList("chop", "stir", "set table"),
                    Arrays.asList("boil"),
                    Arrays.asList("serve")
            )
    );
  // END TEST CASES

    // DO NOT MODIFY BELOW THIS LINE
    public static boolean equalOutputs(List<List<String>> a, List<List<String>> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            List<String> a1 = a.get(i);
            List<String> b1 = b.get(i);
            a1.sort(null);
            b1.sort(null);
            if (!a1.equals(b1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < testInputs.size(); i++) {
            //System.out.println(testInputs.get(i));
            try {

                List<List<String>> result = create_workflow_stages(testInputs.get(i));
                if (equalOutputs(result, testOutputs.get(i))) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
                myList.clear();
            } catch (Exception e) {
                System.out.println("Fail");
                System.out.println(e);
            }
        }
    }
}