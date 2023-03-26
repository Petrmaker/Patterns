package Patterns.Command;

public class Command {
    public static void main(String[] args){
        Atm a = new Atm();
        Client c = new Client(new CheckupAction(a),new CashAction(a),new AdditionAction(a));
        c.checkupMachine();
        c.cashMachine();
        c.additionMachine();
    }
}
interface Action{
    void operation();
}
class Atm{
    void checkup(){
        System.out.println("Перевірка рахунку");
    }
    void cash(){
        System.out.println("Зняти готівку");
    }
    void addition(){
        System.out.println("Поповнити рахунок");
    }
}
class CheckupAction implements Action{
    Atm machine;
    public CheckupAction(Atm machine){this.machine=machine;}
    public void operation(){
        machine.checkup();
    }
}
class CashAction implements Action {
    Atm machine;

    public CashAction(Atm machine) {
        this.machine = machine;
    }

    public void operation() {
        machine.cash();
    }
}
class AdditionAction implements Action {
    Atm machine;

    public AdditionAction(Atm machine) {
        this.machine = machine;
    }

    public void operation() {
        machine.addition();
    }
}
class Client {
    Action checkup;
    Action cash;
    Action addition;

    public Client(Action checkup, Action cash, Action addition) {
        this.checkup = checkup;
        this.cash = cash;
        this.addition = addition;
    }
    void checkupMachine(){
        checkup.operation();
    }
    void cashMachine(){
        cash.operation();
    }
    void additionMachine(){
        addition.operation();

    }
}