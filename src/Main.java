import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            HashMap<String, Integer> scores = new HashMap<>();
            ArrayList<String> incorrect = new ArrayList<>();
            String line = sc.nextLine().trim();
            int score = 0;
            while (!line.equals("-1")) {
                String[] split = line.split(" ");

                int pts = Integer.valueOf(split[0]);
                String problem = split[1];
                String result = split[2];

                if (result.equals("right"))
                    scores.put(problem, pts);
                else
                    incorrect.add(problem);

                line = sc.nextLine();
            }

            for (String key : scores.keySet()) score += scores.get(key);
            for (String wrong : incorrect) {
                if (scores.containsKey(wrong)) score += 20;
            }

            System.out.println(String.format("%s %s",scores.size(), score));

        }

    }

}
