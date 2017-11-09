import java.util.Scanner;
import java.util.Stack;

public class LRUCahce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int simulation = 0;
        while (x != 0) {

            String access = sc.nextLine().trim();
            System.out.println(String.format("Simulation %s",++simulation));
            int length = access.length();
            for (int i  = 0; i < length; i++) {
                if (access.charAt(i) == '!') {
                    Stack<Character> stack = new Stack<>();
                    int j = i-1;
                    while (stack.size() < x && j >= 0) {
                        char c = access.charAt(j);
                        if (c != '!' && !stack.contains(c)) stack.push(access.charAt(j));
                        j -= 1;
                    }
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print("\n");
                }
            }
            x = sc.nextInt();
        }
    }
}
