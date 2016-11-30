package ppl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sazizian
 */
public class ChangeFileFormat {

    public static float vidionFrame11;

    public static ArrayList<DefinationValue> define = new ArrayList<DefinationValue>();
    public static ArrayList<String> items = new ArrayList<String>();
    public static ArrayList<String> itemsDefine = new ArrayList<String>();
    public static ArrayList<String> itemsDefine2 = new ArrayList<String>();
    public ArrayList<String> itemsInclude = new ArrayList<String>();
    public static ArrayList<String> finallist = new ArrayList<String>();

    public String path;
// The main method

    boolean changeFormatFile(File s, File d, String path) {
        System.out.println("Source File=" + s);
        System.out.println("Destination File=" + d);
        System.out.println("Path =" + path);
        path = path;
        items = readFile(s, d);
        itemsDefine = finalPutValuDefination(checkDefine(items));
        checkInclud(itemsDefine, path);
        itemsDefine2 = finalPutValuDefination(itemsDefine);
        printInFIle(deletInclude(itemsDefine2), d);
        return true;
    }

    // This methos check the first commentsuch as "//"
    public boolean checkComment(String s) {
        if (s.indexOf("//") == -1) {
            return true;
        } else {
            return false;
        }
    }

// this method check the second comment (/*    */)
    public ArrayList<String> checkComment2(ArrayList<String> list) {
        ArrayList<String> finalList = new ArrayList<>();
        int[] num = {-1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int count = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals("/*") || list.get(i).startsWith("/*")) {
                num[count] = i;
                ++count;
                // System.out.println("i= " + i + "  Value= " + list.get(i));
            }
            if (list.get(i).equals("*/") || list.get(i).endsWith("*/")) {
                //   System.out.println("i= " + i + "  Value= " + list.get(i));
                num[count] = i;
                ++count;
            }
        }

        int j = 0;
        for (int f = 0; f < list.size(); ++f) {
            if (f != num[j]) {
                finalList.add(list.get(f));
                //  System.out.println(list.get(f));
            } else {
                for (int k = num[j]; k < num[j + 1]; ++k) {
                    ++f;
                }
                j = j + 2;
            }
        }

        return finalList;
    }

    //This methos open files and read it and analys it.
    public ArrayList<String> readFile(File s, File d) {
        InputStream in = null, in2 = null;
        PrintWriter pw = null, pw2 = null;

        StringBuffer str = new StringBuffer();
        try {
            in = new FileInputStream(s);
            FileWriter fw = new FileWriter(d, false);
            pw = new PrintWriter(fw);
            ArrayList<String> list = new ArrayList<>();
            Scanner sl = new Scanner(in);
            while (sl.hasNextLine()) {
                String line = sl.nextLine().replaceAll(",", " , ").replaceAll(";", " ; ");
                if (checkComment(line)) {
                    str.append(line + "\n");
                }
            }
            pw.println(str);
            pw.flush();
            pw.close();
            fw.close();
            in.close();
            in2 = new FileInputStream(d);
            Scanner ss = new Scanner(in2);
            while (ss.hasNext()) {
                list.add(ss.next());
            }
            finallist = checkComment2(list);

            printInFIle(finallist, d);

        } catch (Exception ex) {
            Logger.getLogger(ChangeFileFormat.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                in.close();
                in2.close();
                pw.flush();
                pw.close();
            } catch (IOException ex) {
                Logger.getLogger(ChangeFileFormat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return finallist;
    }

    //This methos check for findinig the #define and delete them and save the values 
    public ArrayList<String> checkDefine(ArrayList<String> list) {

        ArrayList<String> listdef = new ArrayList<String>();
        boolean flag = true;
        for (int i = 0; i < list.size(); ++i) {
            String item = list.get(i);
            if (!(item.equals("\"") || item.contains("\"") || item.startsWith("\"")
                    || item.endsWith("\""))) {

                if (list.get(i).trim().equals("#define")) {
                    define.add(new DefinationValue(list.get(i + 1).trim(), list.get(i + 2).trim()));
                    i = i + 2;
                } else {
                    listdef.add(list.get(i));
                    flag = !flag;
                }

            } else {
                int k = 0;

                while ((i + k + 1) < list.size() && !(list.get(i + k + 1).trim().contains("\""))) {
                    String itm = list.get(i + k);
                    listdef.add(list.get(i + k));
                    ++k;

                }
                i = i + k;
                listdef.add(list.get(i));

            }
        }
        return listdef;
    }

    //This methos write to the file 
    public void printInFIle(ArrayList<String> list, File d) {
        PrintWriter pw = null;
        boolean te1 = true, te2 = true;
        try {
            FileWriter fw = new FileWriter(d, false);
            pw = new PrintWriter(fw);
            for (int f = 0; f < list.size(); ++f) {
                String tt = list.get(f);
                if (list.get(f).endsWith(";")) {
                    pw.println(list.get(f));

                } else {
                    pw.print(list.get(f) + " ");
                }

            }

            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ChangeFileFormat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pw.flush();
                pw.close();
            } catch (Exception ex) {
                Logger.getLogger(ChangeFileFormat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //This method check that wheater this file have #includ or not?
    public ArrayList<String> checkInclud(ArrayList<String> list, String path) {
        ArrayList<String> listInclude = new ArrayList<String>();
        ArrayList<String> listInclude2 = new ArrayList<String>();
        ArrayList<String> listInclude3 = new ArrayList<String>();
        ArrayList<String> listInclude4 = new ArrayList<String>();
        ArrayList<String> listInclude5 = new ArrayList<String>();

        StringBuffer buf = new StringBuffer();
         File d=null;

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals("#include")) {
                String sourceInclude = list.get(i + 1).substring(1, list.get(i + 1).length() - 1);
                //  System.out.println("INCLUDE************** " + sourceInclude);
                String df = sourceInclude.toString().substring(sourceInclude.lastIndexOf("/"), sourceInclude.toString().indexOf("."));
                //  System.out.println("df");

                String desInclude = path + df + "_sasan" + sourceInclude.substring(sourceInclude.indexOf("."), sourceInclude.length());

                File s = new File(sourceInclude);
                 d = new File(desInclude);
                listInclude = readFile(s, d);
              
                listInclude2 = finalPutValuDefination(checkDefine(listInclude));
                listInclude3 = checkInclud(listInclude2, path);
                listInclude4 = finalPutValuDefination(listInclude3);
                listInclude2 = finalPutValuDefination(checkDefine(listInclude));
                listInclude5 = deletInclude(listInclude2);

                if (listInclude5.size() > 1) {
                    for (String h : listInclude5) {
                        if (h.contains(";")) {
                            buf.append(h + " ");
                            buf.append(" \n ");
                        } else {
                            buf.append(h + " ");
                        }

                    }
                    if (buf.length() > 0 && !buf.toString().startsWith("#include")) // listInclude6.add(new IncludeValue(i, buf));
                    {
                        list.set(i, buf.toString());
                    }
                    list.set(i + 1, " ");

                }

                printInFIle(listInclude5, d);
                try {
                    d.delete();
                
                } catch (Exception x) {
                    // File permission problems are caught here.
                    x.printStackTrace();
                }
            }
            //  list.addAll(listInclude5);
        }

        return listInclude5;
    }

    public String checkChar(String a, String b, String c) {
        char[] cA = a.toCharArray();
        char[] cB = b.toCharArray();
        String result = null;
        if (a.equals(b)) {
            result = c;
        } else {
            for (int i = 0; i < cA.length; ++i) {
                if (cA[i] == cB[0]) {
                    result = a.substring(0, i) + c + a.substring(b.length() + i, a.length());
                    break;
                }
            }

        }
        return result;
    }

    public ArrayList<String> finalPutValuDefination(ArrayList<String> list) {

        for (int i = 0; i < define.size(); ++i) {
            for (int j = i + 1; j < define.size(); ++j) {
                if (define.get(i).getItem().equals(define.get(j).getValue())) {
                    define.get(j).setValue(define.get(i).getValue());
                }
            }
        }
//

        for (int j = 0; j < list.size(); ++j) {
            String itm = list.get(j);

            if (!(list.get(j).equals("\"") || list.get(j).contains("\"") || list.get(j).startsWith("\"") || list.get(j).endsWith("\"")
                    || list.get(j).contentEquals("(\"") || list.get(j).contentEquals("(\" "))) {
                for (int i = 0; i < define.size(); ++i) {
                    String it = list.get(j).trim();
                    // System.out.println(it);
                    String ne = define.get(i).getItem().trim();
                    if ((it.equals(define.get(i).getItem().trim()))) {
                        list.set(j, define.get(i).getValue().trim());

                        //       System.out.println(define.get(i).getItem() + "  // " + define.get(i).getValue()+"   list.get(j)="+list.get(j));
                    }
                }

                for (int i = 0; i < define.size(); ++i) {
                    String it = list.get(j).trim();
                    if ((it.contains(define.get(i).getItem().trim()))) {
                        list.set(j, checkChar(list.get(j).trim(), define.get(i).getItem().trim(), define.get(i).getValue().trim()));
                        //   System.out.println(define.get(i).getItem() + "  ELSE// " + define.get(i).getValue()+"   list.get(j)="+list.get(j));                        
                    }
                }

            } else {
                int k = 0;
                while ((j + k + 1) < list.size() && (list.get(j + k + 1).trim().contains("\""))) {
                    ++k;
                }
                j = j + k;
            }

        }

        return list;
    }

    // This method for deleting include line is useful
    public ArrayList<String> deletInclude(ArrayList<String> list) {

        ArrayList<String> delI = new ArrayList<String>();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals("#include")) {
                i = i + 1;
            } else {
                delI.add(list.get(i));
            }

        }
        return delI;
    }

}
