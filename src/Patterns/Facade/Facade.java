package Patterns.Facade;

public class Facade{
    public static void main (String[] args){
        // Телевизор с пультом управления;
        Tv tv = new Tv();
        tv.ControlPanel();
    }
}
class Tv{
    Power power = new Power();
    Program program = new Program();
    TVprogram tVprogram = new TVprogram();
    void ControlPanel(){
        power.on();
        program.action();
        tVprogram.recordFromProgram(program);
    }
}
class Power{
    void on(){
        System.out.println("Просмотр ТВ");
    }
    void off(){
        System.out.println("Виключен");
    }
}
class Program{
    private boolean image = false;
    public boolean watchImage(){
        return image;
    }
    void action(){
        System.out.println("Сделать громче");
        image = true;
    }
    void unaction(){
        System.out.println("Ничего не делать");
        image = false;
    }
}
class TVprogram{
    void recordFromProgram(Program sport) {
        if (sport.watchImage()){
            System.out.println("Записать во время просмотра");
        } else {
            System.out.println("Просмотр без записи");
        }
    }
}
