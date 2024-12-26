// 연습문제 1.

public class A {
    private B b;

}

public class B {
    private String f1;
    private int f2;
}

// 연습문제 2.

public class Test1 {
    private Test2 t2;

    public Test3 method1() {
        Test3 t3 = new Test3();
    }
}

public class Test2 {
    private int f1;

}

public class Test3 {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}

// 연습문제 3.

// 이탤릭체이기 때문에 abstract
public abstract class Parent {
    public void parentMethod() {
        // ...
    }

    // 이탤릭체이기 때문에 abstract
    // --> 정의하지 않은 빈 메소드
    protected abstract void print();
}

public class Child extends Parent {
    private String name;

    public void childMethod() {
        // ...
    }

    // 부모에게서 상속받고 정의해야 함
    protected void print() {
        // ...
    }
}
