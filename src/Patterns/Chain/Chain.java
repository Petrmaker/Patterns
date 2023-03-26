package Patterns.Chain;

public class Chain {
    public static void main(String[]args){
        Supervisor admin = new Administrator(Report.project);
        admin.reply("Новий проект", Report.project);
        Supervisor assistant = new Assistant(Report.performed);
        assistant.reply("В процесі роботи", Report.performed);
        Supervisor laborer = new Laborer(Report.done);
        laborer.reply("Виконана робота", Report.done);
        admin.setNext(assistant);
        assistant.setNext(laborer);

    }
}
class Report{
    public static final int project = 1;
    public static final int performed = 2;
    public static final int done = 3;
}
abstract class Supervisor{
    int priority;
    public Supervisor(int priority){this.priority=priority;}
    //  abstract void reply(String message,int report);
    Supervisor next;
    public void setNext(Supervisor next){this.next = next;}
    public void reply(String message, int report) {
        if (report <= priority) {
            reply(message);
        }
        if (next != null) {
            next.reply(message, report);
        }
    }
    abstract void reply(String message);
}
class Administrator extends Supervisor {
    public Administrator(int priority) {super(priority);}
    public void reply(String message) {System.out.println("Текст: " + message);}
}

    class Assistant extends Supervisor {
        public Assistant(int priority) {super(priority);}
    public void reply(String message) {System.out.println("Текстовий звіт: " + message);}
}
class Laborer extends Supervisor {
    public Laborer(int priority) {super(priority);}
    public void reply(String message){System.out.println("Доклад: " + message);}
}



