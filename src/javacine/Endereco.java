package javacine;

public class Endereco {
    private String cidade;
    private String bairro;
    private String rua;
    private int numeroCasa;

    public Endereco(){}
    
    public Endereco(String cidade, String bairro, String rua, int numeroCasa) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
}
