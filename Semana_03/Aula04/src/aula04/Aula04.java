package aula04;

import java.time.Clock;
import java.util.Scanner;

 class Peixe {
      private int barriga ;
      private int Maxbarriga ;

    public int getBarriga() {
        return barriga;
    }

    public void setBarriga(int barriga) {
        this.barriga = barriga;
    }

    public int getMaxbarriga() {
        return Maxbarriga;
    }

    public void setMaxbarriga(int Maxbarriga) {
        this.Maxbarriga = Maxbarriga;
    }
      
      
      
      public void alimentar(){
          setBarriga(getBarriga() + 1);
          System.out.println("Nhami nhami");
      }
      public void esperar(){
          setBarriga(getBarriga() - 1);
          System.out.println("Affffffffff");
      }
 }

public class Aula04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**System.out.println("Digite alguma coisa!");
        String line = scanner.nextLine();
        System.out.println("Você digitou " + line);
        */
        Peixe nemo = new Peixe();
        nemo.setMaxbarriga(2);
        
        while(true) {
            System.out.println("Digite alimentar ou esperar");
            String Line = scanner.nextLine();
            if(Line.equals("alimentar"))
                nemo.alimentar();
                if (nemo.getBarriga() > nemo.getMaxbarriga()){
                    System.out.println("Nemo explodiu!");
                    break;
                }
            else if(Line.equals("esperar"))
                nemo.esperar();
                if (nemo.getBarriga() <= 0){
                    System.out.println("Nemo morreu de fome!");
                    break;
        }
            else if(Line.equals("end"))
                break;
            else
                System.out.println("Comando invalido");
            
            
        }
    }

    
}
