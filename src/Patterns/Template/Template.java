package Patterns.Template;

public class Template{
    public static void main(String[] args){
        library a = new A();
        a.book();
        System.out.println();
        library b = new B();
        b.book();
        System.out.println();

    }
}
abstract class library {
    void book(){
        System.out.println("Научная литература");
        genres();
        System.out.println("Романы");
        genres2();
    }
    abstract void genres();
    abstract void genres2();
}

    class A extends library{
        void genres() {
            System.out.println("Детективы");
        }
            void genres2(){
                System.out.println("Детская");
        }
    }
    class B extends library{
        void genres(){
            System.out.println("Комедии");
    }
    void genres2(){}
}
