package Patterns;

 public class Delegate{
     public class void main(String[] args) {
         Lawyer lawyer = new Lawyer();
         lawyer.setAgreement(new Trade());
         lawyer.resolved();
         lawyer.setAgreement(new Custumers());
         lawyer.resolved();
         interface Agreement {
             void resolved();
         }
         class Trade implements Agreement{
             public void resolved(){
                 System.out.println("Регулювання угод");
             }
         }
     }
class Custumers implements Agreement{
     public void resolved(){
         System.out.println("Консультація");
     }
 }
 class Lawyer{
     Agreement agreement;
     void setAgreement(Agreement g){
         agreement = g;
     }
     void resolved(){
         agreement, resolved();
     }
 }



