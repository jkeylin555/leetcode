package laioffer;

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

    public static void main(String[] args) {
        LaiOfferManager sun = new LaiOfferManager();
        sun.name = "sun";
        sun.salary = 10000;
        LaiOfferManager.ipo();
        System.out.println(LaiOfferManager.isRich);
        new JavaTest().D();
        B b = new B();
        b.a();
        new B().a();
    }
}
