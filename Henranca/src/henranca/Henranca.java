package henranca;

import java.util.ArrayList;
/**
 * @author igorc
 */
class Gato{
    private String nome;
    private int vidas;
    public Gato(String nome) {
        this.nome = nome;
        this.vidas = 7;
    }
    public String toString(){
        return this.nome + ": miau com " + this.vidas + " vidas!";
    }
}
class GatoRusso extends Gato{
    public GatoRusso(String nome){
        super(nome + "ovisk");
    }
    public String toString(){
        String out = super.toString() + " Miovisk";
        return out;
    }
}

public class Henranca {

    public static void main(String[] args) {
        ArrayList<Gato> saco = new ArrayList<Gato>();
        saco.add(new GatoRusso("Furios"));
        saco.add(new Gato("Bartolomeu"));
        saco.add(new Gato("Chaninha"));
        saco.add(new GatoRusso("Matad"));
        for(Gato gato : saco)
            System.out.println(gato);
        
        }
    }
/**
 * Gato tom = new GatoRusso("Tom");
        tom.miar();
 */
