package laioffer;

import java.util.Arrays;

public class JavaTest {
    public static class LaiOfferManager {
        String name;
        int salary;
        static boolean isRich = false;
        static void ipo() {
            isRich = true;
        }
    }
    void D() {
        new LaiOfferManager();
        new B();
        new A();
    }

    static void E() {
        new LaiOfferManager();
        new B();
//        new A(); can only create static object
    }
    static class B {
        public void a() {
            System.err.println("AAA");
        }
    }
    class C {
        public void a() {
            System.err.println("AAA");
        }
    }
    public class A{
    }
    public class Inner{
    }

    public void doValidStuff(){
        Inner inner = new Inner();
        // no problem, I created it from the context of *this*
    }

    public static void doInvalidStuff(){
//        Inner inner = new Inner();
        // this will fail, as there is no *this* in a static context
    }

    public static double median(double ... numbers) {
        Arrays.sort(numbers);

        int size = numbers.length;
        double median = 0.0;

        if (size > 0) {
            if (size % 2 == 0) {
                double a = numbers[size >> 1];
                double b = numbers[(size >> 1) - 1];
                double c = numbers[size >> 1] + numbers[(size >> 1) - 1];
                median = (numbers[size >> 1] + numbers[(size >> 1) - 1])/2.0;
            }
            else {
                median = numbers[size >> 1];
            }
        }

        return median;
    }

    public static void main(String[] args) {
        LaiOfferManager sun = new LaiOfferManager();
        sun.name = "sun";
        sun.salary = 10000;
        LaiOfferManager.ipo();
//        System.out.println(LaiOfferManager.isRich);
        new JavaTest().D();
        B b = new B();
        b.a();
        new B().a();
        String s = "  hello ";
        s.trim();
       //1 4 7 9 11 21
        double[] numbers = {9, 11, 1, 4, 7, 21};

        JavaTest javaTest = new JavaTest();
        double res = javaTest.median(numbers);

        System.out.println(res);
    }
}
