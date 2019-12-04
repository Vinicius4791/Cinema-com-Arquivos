package javacine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Funcionario extends Pessoa {
    private Endereco endereco = new Endereco();
    
    public Funcionario(){
        super();
    }
    
    public Funcionario(String nome, String identidade, String cpf, Endereco endereco) {
        super(nome, identidade, cpf);
        this.endereco = endereco;
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
        
        return valorConta;
    }
    
    public boolean venderIngresso(Cliente cliente, Date dataCliente, String nomefilme, Cinema cinema, int hora) {
        ArrayList<Sala> salas = cinema.getSalas();
        float valorIngresso;
        Conta conta = cliente.getConta();
        
        for(Sala sala : salas) {
            ArrayList<Sessao> sessoes = sala.getSessoes();
            for(Sessao sessao : sessoes) {
                
                Filme filme = sessao.getFilme();
                int horarioSessao = sessao.getHorario();
                boolean depoisEntrarCartaz = dataCliente.after(sessao.getDataInicio());
                boolean antesSairCartaz = dataCliente.before(sessao.getDataFim());

                if(depoisEntrarCartaz && antesSairCartaz && filme.getTitulo().equals(nomefilme) && hora == horarioSessao) {
                    escolheCadeira(sala, cliente, hora);
                    valorIngresso = valorIngresso(cliente);
                    conta.setValorConta(conta.getValorConta() + valorIngresso);
                    
                    JOptionPane.showMessageDialog(null, "Filme: "+ filme.getTitulo() +"\nSala: "+ sala.getNumeroSala() +
                            "\nData: "+ dataCliente +"\nHorário: "+ hora +":00"
                            , "Ingresso", JOptionPane.PLAIN_MESSAGE);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void escolheCadeira(Sala sala, Cliente cliente, int hora) {
        int linha, coluna;
        
        sala.mostrarSala(hora);
        
        while(true) {
            try {
                linha = Integer.parseInt(JOptionPane.showInputDialog(null, "Linha da cadeira: "));
                coluna = Integer.parseInt(JOptionPane.showInputDialog(null, "Coluna da cadeira: "));
                sala.escolherCadeira(linha, coluna, hora);
                break;
            } catch (CadeiraOcupadaException | NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
                continue;
            }

        }
    }

    public float valorIngresso(Cliente cliente) {
        float valorIngresso;
        
        if(cliente.getIdade() >= 13) {
            valorIngresso = 20;
        } else
          valorIngresso = 10;
        
        return valorIngresso;
    }
    
    public void insereSala(Cinema cinema) {
        Sala sala = new Sala();
        
        sala.setNumeroSala(Integer.parseInt(JOptionPane.showInputDialog(null, "Número da sala: ")));
        
        cinema.setSala(insereSessao(sala));
    }
    
    public Sala insereSessao(Sala sala) {
        int continuar;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        while(true) {
            try {
                Sessao sessao = new Sessao();
                sessao.setDataInicio(sdf.parse(JOptionPane.showInputDialog(null, "Data do ínicio da sessão (dd/MM/yyyy HH): ")));
                sessao.setDataFim(sdf.parse(JOptionPane.showInputDialog(null, "Data do fim da sessão (dd/MM/yyyy HH): ")));
                sessao.setHorario(Integer.parseInt(JOptionPane.showInputDialog(null, "Horário da sessão (HH): ")));

                sessao.setFilme(insereFilme());
                continuar = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja inserir mais uma sessão? [1=S]"));
                sala.setSessao(sessao);
                sessao.disponibilizarCadeiras();
                if(continuar == 1)
                    continue;
                return sala;
            } catch (ParseException | NumberFormatException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Entrada Inválida! ");
                continue;
            }
        }
    }
    
    public  Filme insereFilme() {
        Filme filme = new Filme();
        
        filme.setTitulo(JOptionPane.showInputDialog(null, "Titulo do Filme: "));
        filme.setDuracao(Integer.parseInt(JOptionPane.showInputDialog(null, "Duração: ")));
        filme.setGenero(JOptionPane.showInputDialog(null, "Gênero: "));
        filme.setDescricao(JOptionPane.showInputDialog(null, "Sinopse: "));
        
        return filme;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
