import java.util.Scanner;

public class PythagorasRevenge {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        while (x != 0) {
            int total = 0;
            long limit = (long) (Math.pow(x, 2) - 1) / 2;
            System.out.println(String.format("Starting %s with Limit %s",x,limit));
            Thread.sleep(1000);
            for (long y = x+1; y <= limit; y++) {
                double result = Math.pow(x, 2) * Math.pow(y, 2);
                //System.out.println(String.format("Result is %s",result));
                //Thread.sleep(1000);
                if ((long) result == result) total++;
            }
            System.out.println(total);
            x = sc.nextLong();
        }
    }

}
