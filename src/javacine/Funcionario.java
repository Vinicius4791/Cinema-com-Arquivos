package javacine;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

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
    
    public float venda(Conta conta, int opcao) {
        Vendas vendas = new Vendas();
        float valorConta = 0;
        
        switch (opcao) {
            case 1:
                valorConta += vendas.getPipocaPequena(); break;
            case 2:
                valorConta += vendas.getPipocaGrande();  break;
            case 3:
                valorConta += vendas.getAgua();          break;
            case 4:
                valorConta += vendas.getChocolate();     break;
            case 5:
                valorConta += vendas.getRefrigerante();  break;
        }
        
        conta.setSaldo(conta.getSaldo() - valorConta);
        return valorConta;
    }
    
    public boolean venderIngresso(Cliente cliente, Date dataFilme, Date horarioFilme, String filme, Cinema cinema) {
        ArrayList<Sala> salas = cinema.getSalas();
        long diferenca1, diferenca2;
        float valorIngresso;
        Conta conta = cliente.getConta();
        
        for(Sala sala : salas) {
            Sessao sessao = sala.getSessao();
            Filme nomeFilme = sessao.getFilme();
            diferenca1 = dataFilme.getTime() - sessao.getDataInicio().getTime();
            diferenca2 = sessao.getDataFim().getTime() - dataFilme.getTime();
            if(diferenca1 >= 0 && diferenca2 >= 0 && nomeFilme.equals(filme)) {
                valorIngresso = valorIngresso(cliente);
                conta.setSaldo(conta.getSaldo() - valorIngresso);
                return true;
            }
        }
        return false;
    }
    
    public float valorIngresso(Cliente cliente) {
        float valorIngresso;
        
        if(cliente.getIdade() >= 13) {
            valorIngresso = 20;
        } else
          valorIngresso = 10;
        
        return valorIngresso;
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
