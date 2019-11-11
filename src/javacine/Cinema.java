package javacine;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable{
    private Endereco endereco = new Endereco();
    private ArrayList<Sala> salas = new ArrayList<Sala>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Cinema(){}
    
    public Cinema(Endereco endereco, ArrayList<Sala> salas, ArrayList<Funcionario> funcionarios, ArrayList<Cliente> clientes) {
        this.endereco = endereco;
        this.salas = salas;
        this.funcionarios = funcionarios;
        this.clientes = clientes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public Cliente getCliente(String nomeCliente){
        for (Cliente cliente : clientes) {
            if(cliente.getNome().equals(nomeCliente)){
                return cliente;
            }
        }
        return null;
    }
    
    public void setCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
}
