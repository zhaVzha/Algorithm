package ricky;
import static ricky.Print.*;
public class Test {

    public static void main(String... args){

        Test2 test = new Test2();
        prtln(test.i);
        prtln(test.ch);
        prtln(test.d);
        prtln(test.b);

    }
}

class Test2{

    int i;
    char ch;
    double d;
    boolean b;
}