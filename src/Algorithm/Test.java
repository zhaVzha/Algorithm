package Algorithm;

public   class   Test
{
    private int i = 0 ;
    private String s = new String();
    Test(int j ){
        this.i = j;
        System.out.println(String.format("i = %d",i));
    }
    Test(String a){
        this.s = a;
        System.out.println(String.format("s = %s",s));

    }

    Test(int j, String a) {
        System.out.println("String %% Test");
    }
    Test(){
        System.out.println("default constructor");
    }
    public void print(){
        System.out.println(String.format("i = %d",this.i));
    }
    public   static   void   main(String   argv[])
    {
        Test2 test2 = new Test2();
        test2.get();
    }

}
class Test2 extends Test{
    public void get(){
        System.out.print("Test2");
    }
}