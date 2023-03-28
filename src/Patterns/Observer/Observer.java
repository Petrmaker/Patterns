package Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observer{
    public static void main(String[] args){
        Magazine magazine = new Magazine();
        magazine.addObserverApp(new ClientObserverApp());
        magazine.setChanges("Грає збірна Украіни");
    }
}
interface Observed{
    void addObserverApp(ObserverApp o);
    void removeObserverApp(ObserverApp o);
    void notifyObserver();
}
class Magazine implements Observed {
    String sport;
    List<ObserverApp> observers = new ArrayList<>();
    public void setChanges(String s) {
        sport = s;
        notifyObserverApp();
    }
    public void addObserverApp(ObserverApp o) {
        observers.add(o);
    }
    public void removeObserverApp(ObserverApp o) {
        observers.remove(o);
    }
    public void notifyObserver() {
    }

    public void notifyObserverApp(){
        for (ObserverApp o : observers) {
            o.handleEvent(sport);
        }
    }
}
interface ObserverApp{
    void handleEvent(String sport);
}
class ClientObserverApp implements ObserverApp{
    public void handleEvent(String  sport){
        System.out.println("Вирішальний матч " + sport +" ");
    }
}
