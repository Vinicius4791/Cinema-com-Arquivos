package javacine;

public class Cliente extends Pessoa {
    private String tipoCliente;
    Endereco endereco = new Endereco();
    
    public Cliente(){
        super();
    }
    
    public Cliente(String nome, String identidade, String cpf, int id, String tipoCliente) {
        super(nome, identidade, cpf, id);
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
      
    
}