package pagamento;

import java.util.ArrayList;

/**
 * @author igorc
 */
class Funcionario{
    private String nome;
    private int salario;
    private int multiplo;

    public String getNome() {
        return nome;
    }

    public int getSalario() {
        return salario;
    }

    public int getMultiplo() {
        return multiplo;
    }
    
    
    
    
    public Funcionario(String nome, int multiplo){
        this.nome = nome;
        this.multiplo = multiplo;
        this.salario = 1000 * this.multiplo;
    }
    public String toString(){
        return this.nome + " recebe R$: " + this.salario;
    }
}
class Dono extends Funcionario{
    
    static final private int multiploDono = 10;
    
    public Dono(String nome){
       super(nome, Dono.multiploDono);
    }
    
}



public class Pagamento {

    public static void main(String[] args) {
        ArrayList<Funcionario> receber = new ArrayList<Funcionario>();
        receber.add(new Dono("Igor"));
        
        
            Dono dono1 = new Dono("igor");

        System.out.println(dono1.getNome());
                System.out.println(dono1.getSalario());

                        System.out.println(dono1.getMultiplo());

    }
    
}
