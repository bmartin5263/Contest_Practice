import java.util.Scanner;

public class Juggle {

    private static char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
                                        'R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int patternLength = sc.nextInt();
        while (patternLength != 0) {

            char[] time = new char[20];
            for (int k = 0; k < 20; k++) time[k] = ' ';
            int[] patterns = new int[patternLength];
            for (int i = 0; i < patternLength; i++) patterns[i] = sc.nextInt();
            boolean broke = false;

            int p = 0;
            int letter = 0;
            for (int i = 0; i < 20; i++) {
                if (p == patternLength) p = 0;
                if (time[i] == ' ') {
                    time[i] = letters[letter++];
                }
                int pattern = patterns[p++];
                if (i+pattern < 20) {
                    if (time[i+pattern] == ' ') {
                        time[i + pattern] = time[i];
                    }
                    else {
                        System.out.println("CRASH");
                        broke = true;
                        break;
                    }
                }
            }
            if (!broke) {
                for (int k = 0; k < 20; k++) System.out.print(time[k]);
                System.out.print("\n");
            }
            patternLength = sc.nextInt();
        }
    }
}
