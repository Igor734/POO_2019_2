package controller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author igorc
 */
class Aluno {
	private String nomeAlu;
	ArrayList<String> materiasAluno;
	
	public Aluno(String nome){
		this.nomeAlu = nome;
		this.materiasAluno = new ArrayList<>();
	}
	public String getNomeAluno() {
		return nomeAlu;
	}
	public void setNomeAluno(String nome) {
		this.nomeAlu = nome;
	}	
	public void showMat() {
		System.out.println(this.materiasAluno);
	}
	public void add_mat(String nome){
		this.materiasAluno.add(nome);
	}
	public void rem_mat(String nome){
		this.materiasAluno.remove(nome);
	}
	@Override
	public String toString() {
		return this.getNomeAluno() + this.materiasAluno;
	}

}

class Materia{
	private String nomeMat;
	ArrayList<String> alunosMateria;
	
	public Materia(String nomeMat) {
		this.nomeMat = nomeMat;
		this.alunosMateria = new ArrayList<>();
	}
	public String getNomeMat() {
		return nomeMat;
	}
	public void setNomeMat(String nomeMat) {
		this.nomeMat = nomeMat;
	}
	
	public void showAluno() {
		System.out.println(this.alunosMateria);
	}
	public void add_aluno(String nome){
		this.alunosMateria.add(nome);
	}
	public void rem_aluno(String nome){
		this.alunosMateria.remove(nome);
	}
	@Override
	public String toString() {
		return this.getNomeMat() + this.alunosMateria;
	}
}
class Escola{
	ArrayList<Aluno> alunos;
	ArrayList<Materia> materias;
	
	public Escola(String nome) {
		alunos = new ArrayList<>();
		materias = new ArrayList<>();
		
	}

    Escola() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	public void cadAluno(String nome) {
		Aluno aluno = new Aluno(nome);
		this.alunos.add(aluno);
		System.out.println("Aluno criado");
	}
	
	public void cadMat(String nome) {
		Materia materia = new Materia(nome);
		this.materias.add(materia);
		System.out.println("Materia criado");

	}
	public void addAluno(String aluno, String materia) {
		for(Aluno x : this.alunos){
			if(aluno.equals(x.getNomeAluno())){
				for(Materia y : this.materias){
					if(materia.equals(y.getNomeMat())){
						x.add_mat(materia);
						y.add_aluno(aluno);
						System.out.println("deu bom");
						return;
					}else{
						System.out.println("Matéria não encontrada!");
						return;
					}
				}
			}else{
				System.out.println("Aluno não encontrado!");
				return;
			}
		}
	}

	public void desmatricular(String aluno, String materia) {
		for(Aluno x : this.alunos) {
			if(aluno.equals(x.getNomeAluno())) {
				for(Materia y : this.materias){
					if(materia.equals(y.getNomeMat())){
						x.rem_mat(materia);
						y.rem_aluno(aluno);
					}else{
						System.out.println("Matéria não encontrada!");
						return;
					}
				}
			}else{
				System.out.println("Aluno não encontrado!");
				return;
			}
		}
	}
	public void show_aluno(){
		for(Aluno x : alunos){
			System.out.println(x);
			return;
		}
	}
	public void show_materias(){
		for(Materia y : materias){
			System.out.println(y);
			return;
		}
	}
}

public class Controller {

	public static void main(String[] args) {
		Escola escola = new Escola();
		Scanner scan = new Scanner(System.in);

            OUTER:
            while (true) {
                System.out.println("criarAlu, criarMat, matricular, remover, show, end");
                String line = scan.nextLine();
                String vet[] = line.split(" ");
                switch (vet[0]) {
                    case "criarAlu":
                        escola.cadAluno(vet[1]);
                        break;
                    case "criarMat":
                        escola.cadMat(vet[1]);
                        break;
                    case "matricular":
                        escola.addAluno(vet[1], vet[2]);
                        break;
                    case "remover":
                        escola.desmatricular(vet[1], vet[2]);
                        break;
                    case "show":
                        if(vet[1].equals("alunos")){
                            escola.show_aluno();
                        }
                        if(vet[1].equals("materias")){
                            escola.show_materias();
		}       break;
                    case "end":
                        break OUTER;
                    default:
                        System.out.println("Comando inválido!");
                        break;
                }
            }
    }
}