import java.util.ArrayList;
        import java.util.Scanner;

public class Maze {

    static ArrayList<String> directionMap = new ArrayList<>();
    static ArrayList<String> reverseMap = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static boolean done = false;

    static {
        directionMap.add("up");
        directionMap.add("right");
        directionMap.add("down");
        directionMap.add("left");
        reverseMap.add("down");
        reverseMap.add("left");
        reverseMap.add("up");
        reverseMap.add("right");
    }

    public static void nextDirection(String taken) {
        String origin = "";
        if (!taken.equals("")) {
            int originIndex = directionMap.indexOf(taken);
            origin = reverseMap.get(originIndex);
        }
        for (int i = 0; i < 4; i++) {
            if (!done) {
                String direction = directionMap.get(i);
                if (!direction.equals(origin)) {
                    System.out.println(direction);
                    String next = sc.nextLine();
                    if (next.equals("solved") || next.equals("wrong")) System.exit(0);
                    else if (!next.equals("wall")) {
                        nextDirection(direction);
                    }
                }
            }
        }
        if (!taken.equals("") && !done) {
            System.out.println(origin);
            String next = sc.nextLine();
            if (!next.equals("ok")) System.exit(0);
        }
    }

    public static void main(String[] args) {
        nextDirection("");
        if (!done) {
            System.out.println("no way out");
        }
    }
}