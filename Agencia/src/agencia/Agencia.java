package agencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author igorc
 */
class cliente{
    String id;
    
    public cliente(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "cliente{" + "id=" + id + '}';
    }
    
    
}

class Conta extends cliente{
        int id_conta;
        float saldo;     
        
    public Conta(String id,int num) {
        super(id);
        this.id_conta += num;
        this.saldo = saldo;
    }    
    
    public String toString(){
        return id_conta+":"+id+":"+saldo;
    }
        
        
}


class corrente extends Conta{

    public corrente(String id, int num) {
        super(id, num);
    }

    
    @Override
   public String toString() {
		return super.toString()+ " CC";
	}
  
}

class poupanca extends Conta{

    public poupanca(String id, int num) {
        super(id, num);
    }

    
    public String toString() {
		return super.toString()+ " CP";
	}
}

class banco{
 
        ArrayList<Conta>contas;
        
        public banco(){
            contas = new ArrayList<Conta>();
        }
       
        public void addconta(Conta c){
            contas.add(c);
        }
        
        Conta find(int id){
             for(Conta c : contas){
                 if(c.id_conta == id){
                    return c;
                 }
             }
            throw new RuntimeException("Cliente Não Existe");
        }
        
        public void deposito(int id_conta,int depo){
                    Conta c = find(id_conta);
                    c.saldo += depo;
        }
              
        public void saque(int id_conta,int saque){
                    Conta c = find(id_conta);
                    if(c.saldo > saque){
                        this.contas.get(id_conta).saldo -= saque;
                    }else{
                        System.out.println("Processo não Efetuado\nQuantia Superior ao Saldo");
                    }
          }
        
        public void transferencia(int id_conta1,int id_conta2,int valor){
                saque(id_conta1, valor);
                deposito(id_conta2, valor);
        }
        
        public void update(){
            int taxacc = 20;
            float taxacp = (1.0f/100.0f);
            Conta c = null;
            for(int i = 0;i<contas.size();i++ ){
               if(i == 0 || i % 2 == 0){
                   c = find(i);
                   this.contas.get(i).saldo -= taxacc;
               }else{
                   c = find(i);
                   c.saldo += c.saldo*taxacp;
               }
            }
        }
        
     
    public String toString() {
        return "banco{" + "contas=" + contas + '}';
    }
        
        
}

public class Agencia {

    public static void main(String[] args) {
    banco b = new banco();
        int num_conta = 0;
        
        Scanner scan = new Scanner(System.in);
        while(true){
            String line = scan.nextLine();
            String[] ui = line.split(" ");
            try{
                if (ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addCli")){
                    b.contas.add(new corrente(ui[1],num_conta));
                    num_conta +=1;
                    b.contas.add(new poupanca(ui[1],num_conta));
                    num_conta +=1;
                }else if(ui[0].equals("show")){
                    System.out.println(b.contas);
                }else if(ui[0].equals("deposito")){
                    b.deposito(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
                }else if(ui[0].equals("saque")){
                    b.saque(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
                }else if(ui[0].equals("transf")){
                   b.transferencia(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]),Integer.parseInt(ui[3]));
                }else if(ui[0].equals("update")){
                  b.update();;
                }
                
            }catch(RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
    }
}