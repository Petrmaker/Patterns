package Patterns.factory;

public class Factory {
    public static void main(String[] args){
        PenMaker maker = new BlackPenMaker();
        Pen pen = maker.makePen();
        pen.write();

    }
}
interface Pen{
    void write();
}
class BlackPen implements Pen{
    public void write(){
        System.out.println("Черный шрифт");
    }
}
class GreenPen implements Pen{
    public void write(){
        System.out.println("Зеленый шрифт");
    }
}
interface PenMaker{
    Pen makePen();
}
class BlackPenMaker implements PenMaker{
    public Pen makePen(){
        return new BlackPen();
    }
}
class GreenPenMaker implements PenMaker {
    public Pen makePen() {
        return new GreenPen();
    }
}