package Patterns.State;

public class State{
    public static void main(String[]args){
        TvProgram cinema = new CinemaChannel();
        ProgramTv tv = new ProgramTv();
        tv.setProgram(cinema);
        for(int i = 0; i < 6;i++){
            tv.telecast();
            tv.nextProgram();
        }
    }
}
// Состояние
interface TvProgram{
    void telecast();
}
// Конкретные состояния
class NewsChannel implements TvProgram{
    public void telecast(){System.out.println("Новини ");}
}
class CinemaChannel implements TvProgram{
    public void telecast() {System.out.println("Кіно");}
}
class SportChannel implements TvProgram{
    public void telecast(){System.out.println("Спортивні трансляції");}
}
// Контекст
// Перемикання між станами внутрі контексту
class ProgramTv{
    TvProgram program;
    void setProgram(TvProgram pr){program = pr;}
    void nextProgram(){
        if(program instanceof NewsChannel){
            setProgram(new CinemaChannel());
        }
        else if (program instanceof CinemaChannel){
            setProgram(new SportChannel());
        }
        else if (program instanceof SportChannel){
            setProgram(new NewsChannel());
        }
    }
    // Визначає стан
    void telecast(){
        program.telecast();
    }
}
