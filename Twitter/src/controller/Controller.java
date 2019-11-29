package controller;
/**
 * @author igorc
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



class Usuario{
    String id;
    ArrayList<Usuario> seguidores;
    ArrayList<Usuario> seguidos;

    public Usuario(String id){
        this.id = id;
        seguidores = new ArrayList<>();
        seguidos = new ArrayList<>();
    }

    public void seguir(Usuario other){
        for(Usuario user : seguidos)
            if(user.id.equals(other.id))
                return;
        this.seguidos.add(other);
        other.seguidores.add(this);
    }

    @Override
    public String toString(){
        String saida = id + "\n";
        saida += "Seguidos [ ";
        saida = seguidos.stream().map((user) -> user.id + " ").reduce(saida, String::concat);
        saida += "]\nseguidores [ ";
        saida = seguidores.stream().map((user) -> user.id + " ").reduce(saida, String::concat);
        saida += "]";
        return saida;
    }
}

class Sistema{
    Map<String, Usuario> usuarios;
    public Sistema(){
        usuarios = new TreeMap<>();
    }

    public void addUsuario(String id){
        Usuario user = usuarios.get(id);
        if(user == null){
            usuarios.put(id, new Usuario(id));
        }
    }

    public Usuario getUsuario(String id){
        Usuario user = usuarios.get(id);
        if(user == null)
            throw new RuntimeException("fail: usuario nao encontrado");
        return user;
    }

    @Override
    public String toString(){
        String saida = "";
        saida = usuarios.values().stream().map((user) -> user + "\n").reduce(saida, String::concat);
        return saida;
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();
        OUTER:
        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            try {
                switch (ui[0]) {
                    case "end":
                        break OUTER;
                    case "addUser":
                        sistema.addUsuario(ui[1]);
                        break;
                    case "show":
                        System.out.println(sistema);
                        break;
                    case "follow":
                        Usuario one = sistema.getUsuario(ui[1]);
                        Usuario two = sistema.getUsuario(ui[2]);
                        one.seguir(two);
                        break;
                }
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
    }

}
