package  Patterns;

public class BuilderApp {
    public static void main(String[] args){
        House house = new HouseBuilder()
                .buildMaker("luxHouse")
                .buildBox("Appartment")
                .buildStoreys(3)
                .build();
        System.out.println(house);
    }
}
class House{
    String Maker;
    String Box;
    int Storeys;
    public void setBox(String box) {this.Box = box;}
    public void setMaker(String Maker) {this.Maker = Maker;}
    public void setStoreys(int Storeys) {this.Storeys = Storeys;}
}
class HouseBuilder{
    String M = "Factory";
    String B = "Fasade";
    int S = 3;
    HouseBuilder buildMaker(String M){
        this.M = M;
        return this;
    }
    HouseBuilder buildBox(String B){
        this.B = B;
        return this;
    }
    HouseBuilder buildStoreys(int S){
        this.S = S;
        return this;
    }
    HouseBuilder(){
        House house = new House();
        house.setMaker(M);
        house.setBox(B);
        house.setStoreys(S);
        return house;
    }
}
