package Patterns.Decorator;

public class Decorator {
    public static void main(String[] args){
        PhotoCamera photo = new Camera("Smile");
        photo.makePhoto();
    }
}
interface PhotoCamera{
    void makePhoto();
}
class Camera implements PhotoCamera{
    String value;
    public Camera(String value){this.value = value;}
    public void makePhoto(){
        System.out.print(value);
    }
}
class PhotoFlash implements PhotoCamera{
    PhotoCamera component;
    public PhotoFlash(PhotoCamera component){this.component=component;}
    public void makePhoto() {
        component.makePhoto();
    }
}

