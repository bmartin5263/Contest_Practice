import java.util.*;

public class StackingCups {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int inputSize = sc.nextInt();
        TreeMap<String, Integer> totals = new TreeMap<>();

        for (int i = 0; i < inputSize; i++) {
            int amount;
            String name;
            if (sc.hasNextInt()) {
                amount = sc.nextInt();
                totals.put(sc.next().trim(), amount);
            } else {
                name = sc.next().trim();
                totals.put(name, sc.nextInt() * 2);
            }
        }

        System.out.println(totals.toString());

        while (!totals.isEmpty()) {
            String max = Collections.min(totals.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
            System.out.println(max);
            totals.remove(max);
        }
    }

}
