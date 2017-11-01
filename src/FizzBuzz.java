import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int b = sc.nextInt();
        int range = sc.nextInt();

        for (int i = 1; i <= range; i++) {
            String out = "";
            if (i % f == 0) out += "Fizz";
            if (i % b == 0) out += "Buzz";
            if (out.equals("")) System.out.println(i);
            else System.out.println(out);
        }

    }

}
