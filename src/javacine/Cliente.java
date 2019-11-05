package javacine;

public class Cliente extends Pessoa {
    private String tipoCliente;
    
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
      
    
}