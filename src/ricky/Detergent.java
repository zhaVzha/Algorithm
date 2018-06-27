package ricky;

class Cleaner {
    private String s = new String("Cleanser");
    public void append(String a){s += a;}
    public void dilute(){append("dilute():");}
    public void apply() {append("allpy():");}
    public void scrub() {append("scrub():");}
    public void print(){System.out.println(s);}
    public static void main(String... args){
        Cleaner x = new Cleaner();
        x.dilute();
        x.apply();
        x.scrub();
        x.print();
    }
}

public class Detergent extends Cleaner {
    @Override
    public void scrub(){
        append("Detergent.scrub():");
        super.scrub();
    }
    public void foam(){
        append("foam():");
    }
    public static void main(String... args){
        Detergent x = new Detergent();
        Cleaner y = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.print();
        System.out.println("Testing base class ");
        Cleaner.main();
        System.out.println("Test y:");
        y.dilute();
        y.apply();
        y.scrub();
        y.print();
        System.out.println("Testing base class ");
        Cleaner.main();
    }


}