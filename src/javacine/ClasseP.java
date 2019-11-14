package javacine;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClasseP {
    public static void main(String[] args) {
        int opcao;
        Arquivo arquivo = new Arquivo();
        Cinema cinema = new Cinema();
        cinema = arquivo.read();
        
        while(true) {
            opcao = menu();
            
            if(opcao == 1) {
                cinema.setCliente(cadastraCliente(cinema));
            }
            else if(opcao == 2) {
                mostraCliente(cinema);
            }
            else if(opcao == 3) {
                comprarIngresso(cinema);
            }
            else if(opcao == 4) {
                menuCompras(cinema);
            }
            else if(opcao == 5) {
                arquivo.write(cinema);
                System.exit(0);
            }
            else if(opcao == 6) {
                int senha = 1234, senha1;
                senha1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Senha: "));
                if(senha1 == senha)
                    insereSala(cinema);
                else
                    JOptionPane.showMessageDialog(null, "Senha Incorreta.");
            }
        }
        
        
        
    
    }
    
    public static int menu() {
        int opcao;
        
        while(true){
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem-vindo ao CineJava\n"
                                                                             + "[ 1 ] Cadastrar\n"
                                                                             + "[ 2 ] Exibir Cliente\n"
                                                                             + "[ 3 ] Comprar Ingresso\n"
                                                                             + "[ 4 ] Comprar Comida/bebida\n"
                                                                             + "[ 5 ] Sair"));
                return opcao;
            } catch(NumberFormatException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.PLAIN_MESSAGE);
                continue;
                }
        } 
        
    }
    
    public static Cliente cadastraCliente(Cinema cinema) {
        Cliente cliente = new Cliente();
        
        while(true){
            try{
                cliente.setNome(JOptionPane.showInputDialog(null, "Nome: "));
                cliente.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Idade: ")));
                cliente.setCpf(JOptionPane.showInputDialog(null, "CPF: "));
                cliente.setIdentidade(JOptionPane.showInputDialog(null, "Identidade: "));
                cliente.setEndereco(registraEndereco());
                cliente.setConta(criarConta());
                break;
                } catch(NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.PLAIN_MESSAGE);
                    continue;
            }
        }
        return cliente;
    }
    
    public static Endereco registraEndereco(){
	Endereco endereco = new Endereco();
        
        while(true){
            try{
                endereco.setRua(JOptionPane.showInputDialog(null, "Rua : "));
                endereco.setNumeroCasa(Integer.parseInt(JOptionPane.showInputDialog(null, "Numero: ")));
                endereco.setBairro(JOptionPane.showInputDialog(null, "Bairro: "));
                endereco.setCidade(JOptionPane.showInputDialog(null, "Cidade: "));
                break;
                } catch(NumberFormatException | StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.PLAIN_MESSAGE);
                continue;
            }
        }
	return endereco;
    }
    
    public static Conta criarConta() {
        Conta conta = new Conta();
        
        while(true){
            try{
                conta.setAgencia(Integer.parseInt(JOptionPane.showInputDialog(null, "Numero da Agencia: ")));
                conta.setNumeroConta(Integer.parseInt(JOptionPane.showInputDialog(null, "Numero da Conta: ")));
                break;
                } catch(NumberFormatException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Entrada Inválida");
                continue;
            }
        }
        return conta;
    }
    
    public static void mostraCliente(Cinema cinema){
        String nomeCliente;
        String relatorio;
        
        nomeCliente = JOptionPane.showInputDialog(null, "Nome do Cliente ");
        
        Cliente cliente = cinema.getCliente(nomeCliente);
        Conta conta = cliente.getConta();
        if(cliente != null) {
            relatorio = ("\nNome: "+ cliente.getNome() +"\nIdade: "+ cliente.getIdade() +"\nCPF: "+ cliente.getCpf() 
                    +"Numero da Conta: "+ conta.getNumeroConta());
            JOptionPane.showMessageDialog(null, relatorio, "Relatorio", JOptionPane.PLAIN_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Cliente Inexistente");
        
    }
    
    public static void comprarIngresso(Cinema cinema) {
        ArrayList<Sala> salas = cinema.getSalas();
        Funcionario funcionario = new Funcionario();
        String nomeCliente, filme;
        Date horarioSessao, dataSessao;
        SimpleDateFormat formathora = new SimpleDateFormat("HH");
        SimpleDateFormat formatdata = new SimpleDateFormat("dd/MM/yyyy");
        boolean confirmacao;
        
        nomeCliente = JOptionPane.showInputDialog(null, "Nome do Cliente ");
        
        Cliente cliente = cinema.getCliente(nomeCliente);
        Conta conta = cliente.getConta();
        
        if(cliente != null) {
            while(true){
                try {
                    filme  = JOptionPane.showInputDialog(null, "Qual filme deseja assistir:? ");
                    horarioSessao = formathora.parse(JOptionPane.showInputDialog(null, "Hora da sessão: (HH): "));
                    dataSessao = formatdata.parse(JOptionPane.showInputDialog(null, "Data do fim da sessão (dd/MM/yyyy): "));
                    confirmacao = funcionario.venderIngresso(cliente, dataSessao, horarioSessao, filme, cinema);
                    if(!confirmacao) {
                        JOptionPane.showMessageDialog(null, "Formato indisponível. ");
                        continue;
                    }
                    break;
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                    continue;
                 }
            }
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    public static float menuCompras(Cinema cinema) {
        int opcao, continuar = 1;
        float valorConta = 0;
        String nomeCliente;
        Funcionario funcionario = new Funcionario();
        Cliente cliente = new Cliente();
        
        do{
            nomeCliente = JOptionPane.showInputDialog(null, "Nome do Cliente ");
            cliente = cinema.getCliente(nomeCliente);
        } while(cliente == null);
        
        Conta conta = new Conta();
        
        conta.setAgencia(Integer.parseInt(JOptionPane.showInputDialog(null, "Agencia Bancária: ")));
        conta.setNumeroConta(Integer.parseInt(JOptionPane.showInputDialog(null, "Numero da Conta: ")));
        
        while(continuar == 1) {    
            while(true){
                try{
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem-vindo ao banco Javou\n"
                                                                                 + "[ 1 ] Pipoca Pequena: R$ 4,00\n"
                                                                                 + "[ 2 ] Pipoca Grande: R$ 7,00\n"
                                                                                 + "[ 3 ] Água: R$ 3,00\n"
                                                                                 + "[ 4 ] Chocolate: R$ 4,00\n"
                                                                                 + "[ 5 ] Refrigerante: R$ 6,50"));
                    if(opcao < 1 || opcao > 5) {
                        JOptionPane.showMessageDialog(null, "Opcao Inválida");
                        continue;
                    }
                    
                    valorConta += funcionario.venda(conta, opcao);
                    break;
                } catch(NumberFormatException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.PLAIN_MESSAGE);
                    continue;
                 }
            }
            
            
            do{
                continuar = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja fazer outra compra? [1-S/0-N]"));
            } while(continuar != 1 && continuar != 0);
        }
        
        JOptionPane.showMessageDialog(null, "Total: "+ valorConta, "Conta", JOptionPane.PLAIN_MESSAGE);
        conta.setSaldo(conta.getSaldo() + valorConta);

        return valorConta;
    }
    
    public static void insereSala(Cinema cinema) {
        Sala sala = new Sala();
        Sessao sessao = new Sessao();
        
        SimpleDateFormat formatdata = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formathora = new SimpleDateFormat("HH");
        
        try {
            sessao.setDataInicio(formatdata.parse(JOptionPane.showInputDialog(null, "Data do ínicio da sessão (dd/MM/yyyy): ")));
            sessao.setDataFim(formatdata.parse(JOptionPane.showInputDialog(null, "Data do fim da sessão (dd/MM/yyyy): ")));
            Date data = sessao.getDataFim();
            System.out.println(data);
            
            
            sessao.setFilme(insereFilme());
            sessao.setHorarioSessao(formathora.parse(JOptionPane.showInputDialog(null, "Hora da sessão: (HH): ")));
            sala.criarSala();
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
        sala.setSessao(sessao);
    }
    
    public static Filme insereFilme() {
        Filme filme = new Filme();
        
        filme.setTitulo(JOptionPane.showInputDialog(null, "Titulo do Filme: "));
        filme.setDuracao(Integer.parseInt(JOptionPane.showInputDialog(null, "Duração: ")));
        filme.setGenero(JOptionPane.showInputDialog(null, "Gênero: "));
        filme.setDescricao(JOptionPane.showInputDialog(null, "Sinopse: "));
        
        return filme;
    }
}
