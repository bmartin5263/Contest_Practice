import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MissingPages {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pages = sc.nextInt();

        while (pages != 0) {
            int side = sc.nextInt();
            int midSide = pages / 2;
            int[] otherSides = new int[3];

            int index = 0;
            if (side <= midSide) {
                if (side % 2 == 0) {
                    otherSides[index++] = side - 1;
                } else {
                    otherSides[index++] = side + 1;
                }

            } else {
                if (side % 2 == 0) {
                    otherSides[index++] = side - 1;
                } else {
                    otherSides[index++] = side + 1;
                }
            }
            otherSides[index++] = pages - (otherSides[0] - 1);
            otherSides[index] = pages - (side - 1);
            Arrays.sort(otherSides);
            System.out.println(String.format("%s %s %s", otherSides[0],otherSides[1],otherSides[2]));
            pages = sc.nextInt();
        }
    }
}