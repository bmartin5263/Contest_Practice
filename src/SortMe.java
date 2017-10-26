import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortMe {

    public static String order;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1;
        while (n != 0) {

            order = sc.nextLine().trim();

            String[] words = new String[n];

            for (int i = 0; i < n; i++) words[i] = sc.nextLine();

            Arrays.sort(words, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    int p1 = 0;
                    int p2 = 0;
                    for (int i = 0; i < Math.min(o1.length(), o2.length()) && p1 == p2; i++) {
                        p1 = order.indexOf(o1.charAt(i));
                        p2 = order.indexOf(o2.charAt(i));
                    }

                    if (p1 == p2 && o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    }

                    return p1  - p2  ;
                }
            });

            System.out.println(String.format("year %s",num++));
            for (int j = 0; j < n; j++) {
                System.out.println(words[j]);
            }

            n = sc.nextInt();
        }

    }

}
