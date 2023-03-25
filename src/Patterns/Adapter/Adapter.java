package Patterns.Adapter;

public class Adapter{
    public static void main(String[] args){
        Lock L = new LockAdapterFromVoice();
        L.key();
        L.codeKey();

    }
}
interface Lock{
    void key();
    void codeKey();
}
class voiceLock{
    void voiceKey(){
        System.out.println("Голосовой ключ");
    }
    void codeVoiceKey(){
        System.out.println("Голосовой пароль");
    }
}
class LockAdapterFromVoice extends voiceLock implements Lock{
    public void key(){
        voiceKey();
    }
    public void codeKey(){
        codeVoiceKey();
    }
}







