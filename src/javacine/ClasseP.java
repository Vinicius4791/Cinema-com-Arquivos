package javacine;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ClasseP {
    public static void main(String[] args) {
        int opcao, op = 1, numSala = -1;
        Arquivo arquivo = new Arquivo();
        Cinema cinema = arquivo.read();
        
        if(cinema == null)
            cinema = new Cinema();
        
        Funcionario funcionario = new Funcionario();
        
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
                ArrayList<Sala> salas = cinema.getSalas();
                mostraFilmes(salas);
            }
            else if(opcao == 6) {
                arquivo.write(cinema);
                System.exit(0);
            } else if(opcao == 7) {
                int senha = 1234, senha1;
                
                try {
                    senha1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Senha: "));
                    if(senha1 == senha) {
                        op = menuSessao();
                        if(op == 1)
                            funcionario.insereSala(cinema);
                        else {
                            numSala = Integer.parseInt(JOptionPane.showInputDialog(null, "Número da sala: "));
                            for(Sala sala : cinema.getSalas()) {
                                if(numSala == sala.getNumeroSala())
                                    funcionario.insereSessao(sala);
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Senha Incorreta.");
                } catch(NumberFormatException erro) {
                    System.out.println(erro.getMessage());
                    JOptionPane.showMessageDialog(null, "Entrada Inválida");
                }
            } else
                JOptionPane.showMessageDialog(null, "Opção Inválida");
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
                                                                             + "[ 5 ] Ver Filmes Em Cartaz\n"
                                                                             + "[ 6 ] Sair"));
                return opcao;
            } catch(NumberFormatException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.PLAIN_MESSAGE);
                continue;
                }
        } 
        
    }
    
    public static int menuSessao() {
        int opcao;
        
        while(true){
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem-vindo ao CineJava\n"
                                                                             + "[ 1 ] Inserir sala\n"
                                                                             + "[ 2 ] Inserir uma nova sessao na sala"));
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
        
        if(cliente != null) {
            Conta conta = cliente.getConta();
            relatorio = ("\nNome: "+ cliente.getNome() +"\nIdade: "+ cliente.getIdade() +"\nCPF: "+ cliente.getCpf() 
                    +"\nNumero da Conta: "+ conta.getNumeroConta() +"\nConta: "+ conta.getValorConta());
            JOptionPane.showMessageDialog(null, relatorio, "Relatorio", JOptionPane.PLAIN_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Cliente Inexistente");
        
    }
    
    public static void comprarIngresso(Cinema cinema) {
        Funcionario funcionario = new Funcionario();
        String nomeCliente, filme;
        int dia, mes, ano, hora;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean confirmacao;
        
        nomeCliente = JOptionPane.showInputDialog(null, "Nome do Cliente ");
        
        Cliente cliente = cinema.getCliente(nomeCliente);
        
        if(cliente != null) {
            while(true){
                try {
                    filme  = JOptionPane.showInputDialog(null, "Qual filme deseja assistir:? ");
                    dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia da sessão (dd): "));
                    mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mes da sessão (MM): "));
                    ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano da sessão (yyyy): "));
                    hora = Integer.parseInt(JOptionPane.showInputDialog(null, "Hora da sessão: (HH): "));
                    
                    String data = dia+"/"+mes+"/"+ano;
                    
                    Date dataCliente = sdf.parse(data);
                    confirmacao = funcionario.venderIngresso(cliente, dataCliente, filme, cinema, hora);
                    
                    if(!confirmacao) {
                        JOptionPane.showMessageDialog(null, "Horário indisponível. ");
                        continue;
                    }
                    break;
                } catch (ParseException | NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    continue;
                 }
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Cliente Inexistente");
    }
    
    public static void mostraFilmes(ArrayList<Sala> salas) {
        for(Sala sala : salas) {
            ArrayList<Sessao> sessoes = sala.getSessoes();
            for(Sessao sessao : sessoes) {
                Filme filme = sessao.getFilme();
                JOptionPane.showMessageDialog(null, "Título: "+ filme.getTitulo() +"\nGênero: "+ filme.getGenero() +"\nDuração: "+
                    filme.getDuracao() +"\nSala: "+ sala.getNumeroSala() 
                    +"\nData Disponível: "+ sessao.getDataInicio() +"  à  "+ sessao.getDataFim() +" Horário: "+ sessao.getHorario());
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
        
        Conta conta = cliente.getConta();
        
        try {
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
        } catch(NumberFormatException erro) {
            System.out.println(erro.getMessage());
            JOptionPane.showMessageDialog(null, "Entrada Inválida! ");
            menuCompras(cinema);
        }
        
        
        JOptionPane.showMessageDialog(null, "Total: "+ valorConta +"0", "Conta", JOptionPane.PLAIN_MESSAGE);
        conta.setValorConta(conta.getValorConta() + valorConta);

        return valorConta;
    }
}