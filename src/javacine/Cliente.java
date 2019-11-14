package javacine;

public class Cliente extends Pessoa {
    private int idade;
    Endereco endereco = new Endereco();
    Conta conta = new Conta();
    
    public Cliente(){
        super();
    }
    
    public Cliente(String nome, String identidade, String cpf, int id, int idade) {
        super(nome, identidade, cpf, id);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
      
    
}