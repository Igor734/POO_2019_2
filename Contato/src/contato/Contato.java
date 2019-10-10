package contato;

import java.util.ArrayList;

/**
 *
 * @author igorc
 */
class Fone{
    private String num;
    private String id;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = id;
    }
    public Fone(String num, String id) {
        super();
        this.num = num;
        this.id = id;
    }
    public String toString() {
        return "[" + this.num + ":" + this.id + "]";
    }

}

public class Contato{
    private String nome;
    private ArrayList<Fone> fones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Fone> getFones() {
        return fones;
    }
    public Contato(String nome) {
        super();
        this.nome = nome;
        this.fones = new ArrayList<Fone>();
    }
    public void addFone(String id, String fone){
        this.fones.add(new Fone(id, fone));
    }
    public void rmFone(int index){
        this.fones.remove(index);
    }
    public String toString() {
        return this.nome + ":" + this.getFones();
    }
    public static void main(String[] args){
        Contato igor = new Contato("Igor");
        igor.addFone("casa", "111111111");
        igor.addFone("trab", "222222222");
        igor.addFone("reca", "333333333");
        igor.addFone("univ", "444444444");
        igor.rmFone(1);
        System.out.println(igor);
    }
}