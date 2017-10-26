import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {

            int turns = sc.nextInt();
            ArrayList<Integer> turnCount = new ArrayList<>(n);
            for (int i = 0; i < n; i++) turnCount.add(0);
            int index = -1;
            int check = 0;
            boolean complete = false;
            while (!complete) {
                for (int i = 0; i < turns; i++) {
                    index++;
                    if (index >= turnCount.size()) index = 0;
                    int item = turnCount.get(index);
                    turnCount.set(index, ++item);
                }
                turnCount.remove(index--);
                check = turnCount.get(0);
                complete = true;

                for (int j = 1; j < turnCount.size(); j++) {
                    if (turnCount.get(j-1) != turnCount.get(j)) {
                        complete = false;
                        break;
                    }
                }

            }

            System.out.println(String.format("%s %s", turnCount.size(), check));

            n = sc.nextInt();

        }

    }

}
