import java.util.Scanner;
import java.util.ArrayList;

public class DigitSolitaire {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (x != 0) {
            ArrayList<String> line = new ArrayList<>();
            String xs = String.valueOf(x);
            int xlength = xs.length();
            line.add(xs);
            while (xlength > 1) {
                int product = 1;
                for (int e = 0; e < xlength; e++) {
                    int c = Character.getNumericValue(xs.charAt(e));
                    product *= c;
                }
                xs = String.valueOf(product);
                xlength = xs.length();
                line.add(xs);
            }
            int finalSize = line.size();
            for (int i = 0; i < finalSize; i++) {
                System.out.print(line.get(i));
                if (i != finalSize - 1) System.out.print(" ");
                else System.out.print("\n");
            }
            x = sc.nextInt();
        }
    }

}
