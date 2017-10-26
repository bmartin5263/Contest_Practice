import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DigitSum {

    public static int getMin(ArrayList<Integer> list, boolean ignoreZero) {
        int index = 0;
        while (true) {
            if (list.get(index) == 0 && ignoreZero) index++;
            else return list.remove(index);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n != 0) {
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) nums.add(sc.nextInt());
            Collections.sort(nums);

            ArrayList<Integer> num1 = new ArrayList<>();
            ArrayList<Integer> num2 = new ArrayList<>();
            ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
            arrays.add(num1);
            arrays.add(num2);
            int pointer = 0;

            boolean isOdd = (n % 2 != 0);

            for (int i = 0; i < n; i++) {
                int min;
                if (arrays.get(pointer).size() == 0) {
                    min = getMin(nums, true);
                } else {
                    min = getMin(nums, false);
                }
                arrays.get(pointer).add(min);
                if (!isOdd) {
                    if (pointer == 0) pointer = 1;
                    else pointer = 0;
                } else {
                    isOdd = false;
                }
            }
            int finalSum = 0;
            for (int i = 0; i < 2; i++) {
                StringBuilder sb = new StringBuilder();
                for (int v : arrays.get(i))
                {
                    sb.append(String.valueOf(v));
                }
                finalSum += Integer.valueOf(sb.toString());
            }

            System.out.println(finalSum);

            n = sc.nextInt();
        }

    }

}
