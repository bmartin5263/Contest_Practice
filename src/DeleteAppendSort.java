import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class DeleteAppendSort {

    /*
    SAMPLE INPUT
    3
    1 3
    1 3 2
    2 6
    1 5 2 4 3 6
    3 23
    67890 56312 999999999 12345 23456 38927 45632 100345 98765 23456
    87654 43278 23456 117654 321899 25432 54326 217435 26845 31782
    33456 41234 56213

    SAMPLE OUTPUT
    1 1
    2 3
    3 15
    */

    static ArrayList<Long> sorted = null;

    public static boolean isSorted(ArrayList<Long> list) {
        int size = list.size()-1;
        for (int i = 0; i < size; i++) {
            if (list.get(i) > list.get(i+1)) return false;
        }
        return true;
    }

    public static int DA(ArrayList<Long> list, int count) {
        if (isSorted(list)) return count;
        Long x = sorted.get(count);
        list.remove(x);
        return DA(list, ++count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputSize = sc.nextInt();

        while (sc.hasNextLong()) {
            long index = sc.nextLong();
            long size = sc.nextLong();
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(sc.nextLong());
            }
            sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            Collections.reverse(sorted);
            String formattedString = String.format("%s %s",index, DA(list, 0));
            System.out.println(formattedString);
        }
    }

}
