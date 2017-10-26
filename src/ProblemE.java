import java.util.ArrayList;
import java.util.Scanner;

public class ProblemE {

    public static ArrayList<ArrayList<Integer>> getPermutations(int[] nums) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        output.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {

            ArrayList<ArrayList<Integer>> current = new ArrayList<>();

            for (ArrayList<Integer> list : output) {
                for (int j = 0; j < list.size()+1; j++) {
                    list.add(j, nums[i]);
                    ArrayList<Integer> temp = new ArrayList<>(list);
                    System.out.println(temp);
                    current.add(temp);
                    list.remove(j);
                }
            }
            output = new ArrayList<>(current);
        }

        return output;
    }

    public static int[] getArray(int size) {
        int[] x = new int[size];
        for (int i = 0; i < size; i++) {
            x[i] = i+1;
        }
        return x;
    }

    public static int desCount(ArrayList<Integer> permutation) {
        int out = 0;
        for (int i = 0; i < permutation.size()-1; i++) {
            int k = permutation.get(i);
            int kk = permutation.get(i+1);
            if (k > kk) out++;
        }
        return out;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int inputSize = sc.nextInt();
        int[] size = new int[inputSize];
        int[] desc = new int[inputSize];

        while (sc.hasNextInt()) {
            int index = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            size[index-1] = s;
            desc[index-1] = d;
        }

        for (int i = 0; i < inputSize; i++) {
            int[] list = getArray(size[i]);
            int dCount = desc[i];
            int total = 0;
            ArrayList<ArrayList<Integer>> permutations = getPermutations(list);
            for (int j = 0; j < permutations.size(); j++) {
                ArrayList<Integer> permutation = permutations.get(j);
                if (desCount(permutation) == dCount) total++;
            }
            String formattedString = String.format("%s %s",i+1,total);
            System.out.println(formattedString);
        }

    }
}
