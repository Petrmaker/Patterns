package Patterns.Prototape;

public class Prototype {
    public static void main(String[] args) {
        Smartphone original = new Smartphone("Ipnone", "USA", 500);
        System.out.println(original);
        Smartphone copy = (Smartphone) original.copy();
        System.out.println(copy);
    }
}
interface Copyble {
    Object copy();
}
class Smartphone implements Copyble {
    String brand;
    String maker;
    int price;
    public Smartphone(String brand, String maker, int price) {
        this.brand = brand;
        this.maker = maker;
        this.price = price;
    }

    public Object copy() {
        Smartphone copy = new Smartphone(brand, maker, price);
        return copy;
    }
}
