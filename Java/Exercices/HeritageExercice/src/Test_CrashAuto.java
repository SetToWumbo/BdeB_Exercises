public class Test_CrashAuto extends Test1{

    public static void main(String[] args) {
       Test1 one = new  Test1();
        System.out.println(one.numTest);
       Test1 two = new Test1("Test", 50.2356, false, "Bob");
        System.out.println(two.numTest);
        one.numTest+=5;
        System.out.println (one.numTest);
        System.out.println(two.numTest);



    }





}