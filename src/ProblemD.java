import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedList;

public class ProblemD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputSize = sc.nextInt();
        int[] nums = new int[inputSize];

        while (sc.hasNextInt()) {
            int index = sc.nextInt();
            int number = sc.nextInt();
            nums[index - 1] = number;
        }

        for (int i = 0; i < inputSize; i++) {
            LinkedList<Boolean> directions = new LinkedList<>();
            int number = nums[i];
            while (number > 1) {
                if (number % 2 == 0) {
                    number = number / 2;
                    directions.add(false);      //GO RIGHT
                } else {
                    number = (number-1) / 2;
                    directions.add(true);       //GO LEFT
                }
            }
            int p = 1;
            int q = 1;
            Iterator x = directions.descendingIterator();
            while (x.hasNext()) {
                boolean direction = (boolean) x.next();
                if (direction) p = p+q;
                else q = p+q;
            }
            String formattedString = String.format("%s %s/%s",i+1,p,q);
            System.out.println(formattedString);
        }

    }

}
