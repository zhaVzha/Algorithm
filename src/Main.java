import ricky.*;
import static ricky.Print.*;

public class Main extends Test {
    public static void main(String[] args) {
        final int[] a = {1,2,3,4,5};
        for (int i = 0; i < 5; i++) {
            a[i]++;
            prt(a[i]+" ");
        }
    }

}