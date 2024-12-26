// 연습문제 4
public abstract class Shape {
    public void draw() {
        // draw
    }

    public void erase() {
        // erase
    }

    public int getLength() {
        return 1;
    }

    protected abstract double getArea();

}

public interface Resizable {
    // interface 에선 묵시적으로 public void abstract 라고 인식
    void resize();

}

public class Rectangle extends Shape implements Resizable {
    public boolean isSquare() {
        // it it square
    }

    protected double getArea() {
        // calculate area
    }

    public void resize() {
        // resize the square
    }
}

public class Triangle extends Shape implements Resizable {
    public boolean isEquilateral() {
        // it it equilateral
    }

    protected double getArea() {
        // calculate area
    }

    public void resize() {
        // resize the triangle
    }
}

// 연습문제 5
// 5-1
public class ClassRoom {
    private Student std;

    public ClassRoom(Student std) {
        this.std = std;
    }

}

public class Student {
    private String name;
    private int age;
}

// 5-2
public class Library {
    private Book book;

    public Library(Book book) {
        this.book = new Book();
    }

    public class Book {
        private String title;
        private String author;

        public Book() {
        }
    }

}

// 연습문제 6
public class Shop {
    private Product product;
    private Employee emp;

    public Shop(Product p) {
        this.product = p;
        this.emp = new Employee();
    }
}

public class Product {
    private String pName;
    private int price;
}

public class Employee {
    private String name;
}

// 연습문제 7

public abstract class Coffee {
    public String beans;
}

public class CafeLatte extends Coffee {
    private String temperature;
    private int price;

    public void drink() {
        Option opt = new Option();
    };

}

public class Cafe {
    private String name;
    private String address;
    private CafeLatte latte;

    public Cafe(CafeLatte latte) {
        this.latte = latte;
    }
}

public class Option {
    private int shot;
    private String ice;
    private int syrup;
}
