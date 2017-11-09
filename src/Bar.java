import java.util.ArrayList;
import java.util.Collections;

class IntRef {
    final int n;
    IntRef (int n) {this.n = n;}
}

class C {
    IntRef r;
    C (IntRef r) {this.r = r;}
}

public class Bar {

    public static void f(C c) {
        c.r = new IntRef(c.r.n*3);
    }


    public static void main(String[] args) {
        IntRef s = new IntRef(2);
        C c = new C(s);
        f(c);
        System.out.println(s.n*c.r.n);
    }

}
