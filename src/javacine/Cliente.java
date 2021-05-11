package javacine;

public class Cliente extends Pessoa {
    private int idade;
    Conta conta = new Conta();
    
    public Cliente(){
        super();
    }
    
    public Cliente(String nome, String identidade, String cpf, int idade, Endereco endereco) {
        super(nome, identidade, cpf, endereco);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
      
    
}