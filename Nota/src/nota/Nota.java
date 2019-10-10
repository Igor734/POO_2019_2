package nota;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author igorc
 */
class Aluno {
    private String nome;
    private String nota;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String id) {
        this.nota = nota;
    }
    public Aluno(String nome, String nota){
        this.nome = nome;
        this.nota = nota;
    }
    public String toString() {
        return "[" + this.nome + ":" + this.nota + "]";
    }
}

public class Nota {
    private String nome;
    private ArrayList<Aluno> alunos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aluno> getAluno() {
        return alunos;
    }
    
public Nota(String nome) {
    this.nome = nome;
    this.alunos = new ArrayList<Aluno>();
}
public void addAluno(String nota, String aluno){
    this.alunos.add(new Aluno(nota, aluno));
}
public String toString(){
    return this.nome + ":" + this.getAluno();
}
public static void main(String[] args) {
    Nota ap1 = new Nota("Ap1");
    ap1.addAluno("Igor", "10");
    ap1.addAluno("João", "8");
    ap1.addAluno("Eduardo", "9");
    ap1.addAluno("Junior", "5");
    Nota ap2 = new Nota("Ap2");
    ap2.addAluno("Igor", "9");
    ap2.addAluno("João", "8");
    ap2.addAluno("Eduardo", "7");
    ap2.addAluno("Junior", "6");
    System.out.println(ap1);
    System.out.println(ap2);
}
}
