package Les08.Les088;
public class A {
    protected void a1() { System.out.println("Hello A"); }
    protected void a2() { a1(); }
    protected void a3() { }
}
class B extends A {
    protected void a1() { System.out.println("Bye B"); }
    protected void a3() { }
}
class C extends B {
    protected void a1() { System.out.println("Bye C"); }
    protected void a3() { }
}
class Main {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        A c = new C();

        a.a2();
        b.a2();
        c.a2();
    }
}