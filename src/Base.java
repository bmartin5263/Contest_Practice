import java.util.Scanner;

public class Base {

    /*
    SAMPLE INPUT
    4
    1 1234
    2 9
    3 1777
    4 129

    SAMPLE OUTPUT
    1 668 1234 4660
    2 0 9 9
    3 1023 1777 6007
    4 0 129 297
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long inputSize = sc.nextInt();
        long[] nums = new long[(int) inputSize];
        while (sc.hasNextLong()) {
            long index = sc.nextLong();
            long number = sc.nextLong();
            nums[(int) index-1] = number;
        }
        for (int i = 0; i < inputSize; i++) {
            long value = nums[i];
            long hexi = Long.parseLong(String.valueOf(value), 16);
            long octal;
            try
            {
                octal = Long.parseLong(String.valueOf(value), 8);
            }
            catch (Exception e)
            {
                octal = 0;
            }
            String formatted = String.format("%s %s %s %s",i+1,octal, value, hexi);
            System.out.println(formatted);
        }
    }

}
