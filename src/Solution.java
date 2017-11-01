import java.io.*;
import java.util.*;

public class Solution {

    public static void main (String[] args) {

        List<String> stringList = new ArrayList<String>();

        stringList.add("abcd");
        stringList.add("abdc");
        stringList.add("acbd");
        stringList.add("acdb");
        stringList.add("xyz");
        stringList.add("xzy");
        stringList.add("wxyz");

        List<List<String>> finalList = anagramFinder(stringList);

        for (List topList: finalList) {
            for(int i = 0; i < topList.size(); i++) {
                System.out.print(topList.get(i));
                System.out.print(", ");
            }//for anagramList
            System.out.println("\n");
        }//for toplist

    }//main

    public static List<List<String>> anagramFinder(List<String> stringList) {

        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String currentString : stringList) {

            char[] tempCharArray = currentString.toCharArray();
            Arrays.sort(tempCharArray);
            String sortedString = new String(tempCharArray);

            List<String> tempStringList = anagramMap.get(sortedString);

            if (tempStringList == null) {
                tempStringList = new ArrayList<>();
            }//if

            tempStringList.add(currentString);
            anagramMap.put(sortedString, tempStringList);
        }//for

        return new ArrayList<List<String>>(anagramMap.values());
    }//anagramFinder
}