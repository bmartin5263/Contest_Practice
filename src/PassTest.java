import java.lang.reflect.Array;
import java.util.ArrayList;

class RefInt {
    int x = 0;
}

public class PassTest {

    public static void edit(RefInt r) {
        r.x = 99;
    }

    public static void main(String[] args) {
        RefInt r = new RefInt();
        System.out.println(r.x);
        edit(r);
        System.out.println(r.x);
    }

}
