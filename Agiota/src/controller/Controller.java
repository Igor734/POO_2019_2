package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author igorc
 */
class Transacao{
    int id;
    float value;
    String clientId;

    public Transacao(int id, float value, String clientId) {
        this.id = id;
        this.value = value;
        this.clientId = clientId;
    }

    @Override
    public String toString(){
        return "" + id + ":" + value + ":" + clientId;
    }
}

class Cliente{
    String id;
    String fullname;
    float  saldo;
    public Cliente(String id, String fullname){
        this.id = id;
        this.fullname = fullname;
        this.saldo = 0;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.fullname + ":" + this.saldo;
    }
}

class Sistema {
    float saldo;
    ArrayList<Cliente> clientes;
    ArrayList<Transacao> transacoes;
    int IdTran;

    public Sistema(float saldo) {
        this.saldo = saldo;
        this.clientes = new ArrayList<>();
        this.transacoes = new ArrayList<>();
        this.IdTran = 0;
    }

    void cadastrar(Cliente cliente) {
        try {
            this.findCliente(cliente.id);
            throw new RuntimeException("Cliente ja exite");
        }catch(RuntimeException re){
            clientes.add(cliente);
        }
    }

    Cliente findCliente(String id) {
        for (Cliente cli : clientes) {
            if (cli.id.equals(id))
                return cli;
        }
        throw new RuntimeException("fail: cliente nao existe");
    }

    void addTransacao(float value, String clienteId) {
        this.transacoes.add(new Transacao(IdTran, value, clienteId));
        IdTran += 1;
    }

    void emprestar(String id, float saldo) {
        Cliente cli = findCliente(id);
        addTransacao(-saldo, id);
        this.saldo -= saldo;
        cli.saldo += saldo;
    }

    void receber(String id, float saldo) {
        Cliente cli = findCliente(id);
        if(cli.saldo < saldo){
            System.out.println("fail: pagamento maior que divida");
            return;
        }
        addTransacao(saldo, id);
        cli.saldo -= saldo;
        this.saldo += saldo;
    }

    ArrayList<Transacao> getHistorico() {
        return transacoes;
    }


    @Override
    public String toString() {
        String saida = "";
        saida = clientes.stream().map((cliente) -> cliente + "\n").reduce(saida, String::concat);
        saida += "saldo:" + this.saldo;
        return saida;
    }
}

public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        OUTER:
        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            try {
                switch (ui[0]) {
                    case "end":
                        break OUTER;
                    case "init":
                        sistema = new Sistema(Float.parseFloat(ui[1]));
                        break;
                    case "show":
                        System.out.println(sistema);
                        break;
                    case "emprestar":
                        sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
                        break;
                    case "historico":
                        for (Transacao tr : sistema.getHistorico())
                            System.out.println(tr);
                        break;
                    case "addCli":
                        String id = ui[1];
                        String[] subarray = Arrays.copyOfRange(ui, 2, ui.length);
                        String fullname = String.join(" ", subarray);
                        sistema.cadastrar(new Cliente(id, fullname));
                        break;
                    default:
                        System.out.println("fail: comando invalido");
                        break;
                }
            }catch(RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
    }
}