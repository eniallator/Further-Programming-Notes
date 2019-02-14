package Week2.Inheritance;

public class B extends A {
    int b;

    public B() {
        b = 0;
    }

    @Override
    public boolean isA() {
        b += 1;
        return a;
    }

    public int getB() {
        return b;
    }
}
