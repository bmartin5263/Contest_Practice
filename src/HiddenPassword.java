import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class HiddenPassword {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] split = input.split(" ");
            char[] code = split[0].toCharArray();
            char[] pass = split[1].toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = code.length-1; i >= 0; i--) {
                stack.push(code[i]);
            }

            boolean success = false;
            for (int i = 0; i < pass.length; i++) {
                if (pass[i] == stack.peek()) stack.pop();
                else {
                    boolean broken = false;
                    for (int e = 0; e < stack.size()-1; e++) {
                        if (stack.get(e) == pass[i]) {
                            broken = true;
                            break;
                        }
                    }
                    if (broken) break;
                }
                if (stack.isEmpty()) {
                    success = true;
                    break;
                }
            }
            if (success) System.out.println("PASS");
            else System.out.println("FAIL");

        }
    }

}
