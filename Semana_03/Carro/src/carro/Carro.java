package carro;

import java.util.Scanner;

/**
 * @author igorc
 */

class Veiculo {
    String modelo;
    public int combustivel;
    public int combustivelMax;

    public int getCombustivel() {return combustivel;}

    public void setCombustivel(int combustivel) {
        if(combustivel > this.combustivelMax)
            this.combustivel = this.combustivelMax;
        else if(combustivelMax <= 0){
            this.combustivel = 0;
        }else
            this.combustivel = combustivel;
    }

    public int getCombustivelMax() {return combustivelMax;}

    public void setCombustivelMax(int combustivelMax) {
        this.combustivelMax = combustivelMax;
    }
    
    public void andar(){
        if(this.combustivel > 0){
            this.setCombustivel(this.getCombustivel() -1);
            return;
        }else{
            System.out.println("Falha: Seu carro está sem combustivel!");
        }
    }
    
    public void abastecer(){
        if(this.combustivelMax == this.combustivel){
            System.out.println("Falha: Seu carro está com o tanque cheio!");
            return;
        }else{
            this.setCombustivel(this.getCombustivelMax());
        }
    }
    
    public Veiculo(String nome, int combustivel){
        this.combustivel = combustivel;
        this.combustivelMax = combustivelMax;
    }
}

public class Carro {
    private static Object scanner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veiculo carro = new Veiculo("", 0);
        carro.setCombustivelMax(5);
        
        while(true) {
            System.out.println("Digite andar");
            String Line = scanner.nextLine();
            if(Line.equals("show"))
                System.out.println(carro);
            else if(Line.equals("andar"))
                carro.andar();
            else if(Line.equals("abastecer"))
                carro.abastecer();
            else if(Line.equals("end"))
                break;
            else
                System.out.println("Comando invalido");
            
            
        }
    }
}
    
    
   
