import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Collections;

public class Problem {

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
