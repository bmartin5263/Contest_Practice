import java.util.Iterator;

public class Repeat {

    public static <T> Iterator<T> repeat(T e, int num) {
        return new Iterator<T>() {
            private T object = e;
            private int repeatNumber = num;
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < repeatNumber;
            }

            @Override
            public T next() {
                counter++;
                return object;
            }

        };
    }

    public static void main(String[] args) {
        Iterator<String> iter = repeat("Test repeater", 7);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
