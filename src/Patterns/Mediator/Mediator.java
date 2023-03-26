package Patterns.Mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator{
    public static void main(String[] args){
        ChatBot shop = new ChatBot();
        Client owner = new Owner(shop);
        Client c1 = new NewClient(shop);
        Client c2 = new NewClient(shop);
        shop.setOwner(owner);
        shop.addClient(c1);
        shop.addClient(c2);
        c1.sendMessage("Доброго дня,маю бажання стати вашим клієнтом ");
        owner.sendMessage("Яка група товарів вас цікавить ?");
    }
}
interface Client{
    void sendMessage(String message);
    void getMessage(String message);
}
class Owner implements Client{
    Shop shop;
    public Owner(Shop shop){this.shop=shop;}
    public void sendMessage(String message){
        shop.sendMessage(message,this);
    }
    public void getMessage(String message){
        System.out.println("Власник отримує повідомлення '"+ message +"'");
    }
}
class NewClient implements Client{
    Shop shop;
    public NewClient(Shop shop){this.shop=shop;}
    public void sendMessage(String message){
        shop.sendMessage(message,this);
    }
    public void getMessage(String message){
        System.out.println("Клієнт отримує повідомлення "+ message +"");
    }
}
interface Shop{
    void sendMessage(String message,Client client);
}
class ChatBot implements Shop{
    Client owner;
    List<Client> clients = new ArrayList<>();
    public void setOwner(Client owner){
        this.owner=owner;
    }
    public void addClient(Client c){
        clients.add(c);
    }
    public void sendMessage(String message, Client client) {
        for(Client c: clients){
            c.getMessage(message);
        }
        owner.getMessage(message);
    }
}




