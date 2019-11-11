package javacine;

public class Funcionario extends Pessoa {
    private String funcao;
    private double salario;
    
    public Funcionario(){
        super();
    }
    
    public Funcionario(String nome, String identidade, String cpf, int id, String funcao, double salario) {
        super(nome, identidade, cpf, id);
        this.funcao = funcao;
        this.salario = salario;
    }
    
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
