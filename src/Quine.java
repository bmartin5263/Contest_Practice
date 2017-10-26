import java.util.ArrayList;
import java.util.Scanner;

public class Quine {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!line.equals("END")) {

            ArrayList<Character> quine = new ArrayList<>();

            int strlen = line.length();
            if (strlen < 5 || line.charAt(0) != '"') {
                System.out.println("not a quine");
            } else {
                int i = 1;
                char c = line.charAt(i);
                boolean overflow = false;
                while (c != '"') {
                    quine.add(c);
                    try {
                        c = line.charAt(++i);
                    } catch (Exception e) {
                        overflow = true;
                        break;
                    }
                }
                if (!overflow && line.charAt(++i) == ' ') {
                    i++;
                    int j = 0;
                    char k;
                    boolean broken = false;
                    while (i < strlen) {
                        c = line.charAt(i);
                        try {
                            k = quine.get(j);
                            if (c != k) {
                                System.out.println("not a quine");
                                broken = true;
                                break;
                            } else {
                                i++;
                                j++;
                            }
                        } catch (Exception e) {
                            System.out.println("not a quine");
                            broken = true;
                            break;
                        }
                    }
                    if (!broken) {
                        StringBuilder finalQuine = new StringBuilder();
                        for (Character s : quine) finalQuine.append(s);
                        System.out.println(String.format("Quine(%s)",finalQuine.toString()));
                    }
                } else {
                    System.out.println("not a quine");
                }
            }

            line = sc.nextLine();
        }
    }
}
