package Les08;

public class Main {

    public static void main(String[] args)
    {
       BOO boo = new BOO();
        B b1 = new A();
        B b2 = new C();
        A a1 = (C) b2;
        D d1 = new C();
        B b3 = new B();
        D d2 = new A();



    }


}


class A  extends D{}
class B{}
class C extends A {}
class D extends B {}

//class A  extends B{}
//class B{}
//class C extends D{}
//class D extends A{}


