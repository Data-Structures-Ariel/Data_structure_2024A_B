package Les09;


import java.awt.*;

public class Main {

    public static void main(String[] args) {
        A[] data = new A[5];
        data[0] = new A(5);
        data[1] = new B(5, 10);
        data[2] = new C(5, 10, 15);
        data[3] = data[0];
        data[4] = new B(5);
        for (int i = 0; i < data.length; i++)
            System.out.println(data[i]);
        for (int i = 0; i < data.length; i++)
            data[i].change();
        for (int i = 0; i < data.length; i++)
            System.out.println(data[i]);


//        A a = new A();
//        B b = new B(2);
//        C c = new C();


        Shape s = new Square(new Point(50, 50), 10);
        Shape c = new Circle(new Point(50, 50), 8);
        ITurnable t;
        IFillable f;


//        f = (IFillable) c;
//        t = (Square)s;
//        t.fill("Green");
//        f = c;
//        f.fill("Red");
//        ((Circle) s).left(45);
//        Shape d = c;
//        d.fill("Yellow");
//        f = new Rectangle(new Point(10, 10), 10, 20);
//        f.left(Math.PI);
//        c = s;
//        c.left(90);
    }


}

interface IFillable {
    void fill(String color);
}

interface ITurnable {
    void left(int degree);

    void right(int degree);
}

class Shape {
    protected String color;
    protected Point point;
}

class Square extends Shape implements IFillable, ITurnable {
    protected double length1;

    public Square(Point p, double length1) {
        this.length1 = length1;
    }

    @Override
    public void fill(String color) {

    }

    @Override
    public void left(int degree) {

    }

    @Override
    public void right(int degree) {

    }
}

class Rectangle extends Square {
    private double length2;

    public Rectangle(Point p, double length1) {
        super(p, length1);
    }

    public Rectangle(Point point, int i, int i1) {
        super(point, i);

    }
}

class Circle extends Shape implements IFillable {
    private double radius;

    public Circle(Point p, double radius) {
        this.radius = radius;
    }

    @Override
    public void fill(String color) {

    }
}

class A {
    protected int x;

    public A() {
        this.x = 1;
        System.out.println("Hello A()");
    }

    public A(int x) {
        this.x = x;
        System.out.println("Hello A(int x)");
    }

    public void change() {
        this.x = this.x * 2;
    }

    public String toString() {
        return "X=" + this.x;
    }
}

class B extends A {
    protected int y;

    public B() {
        super();
        this.y = -y;
        System.out.println("Hello B()");
    }

    public B(int y) {
        super();
        this.y = -y;
        System.out.println("Hello B(int y)");
    }

    public B(int x, int y) {
        super(x);
        this.y = -y;
        System.out.println("Hello B(int x, int y)");
    }

    public String toString() {
        return super.toString() + " Y=" + this.y;
    }
}

class C extends B {
    private int z;

    public C() {
        super();
        System.out.println("Hello  C()");
        this.z = z;
    }

    public C(int x, int y, int z) {
        super(x, y);
        System.out.println("Hello  C(int x, int y, int z)");
        this.z = z;
    }

    public void change() {
        this.x = 3 * this.x;
        this.y = 3 * this.y;
        this.z = 3 * this.z;
    }

    public String toString() {
        return super.toString() + " Z=" + this.z;
    }
}