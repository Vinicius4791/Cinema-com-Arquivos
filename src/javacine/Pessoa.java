package javacine;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private String nome;
    private String identidade;
    private String cpf;
    private Endereco endereco = new Endereco();

    public Pessoa(){}
    
    public Pessoa(String nome, String identidade, String cpf, Endereco endereco) {
        this.nome = nome;
        this.identidade = identidade;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
