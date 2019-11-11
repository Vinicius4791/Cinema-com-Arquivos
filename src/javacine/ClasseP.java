package javacine;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClasseP {
    public static void main(String[] args) {
        int opcao;
        Cinema cinema = new Cinema();
        
        while(true) {
            opcao = menu();
            
            if(opcao == 1) {
                cinema.setCliente(cadastraCliente(cinema));
            }
            else if(opcao == 2) {
                mostraCliente(cinema);
            }
        }
        
        
        
    
    }
    
    public static int menu() {
        int opcao;
        
        while(true){
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem-vindo ao banco Javou\n"
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
    
    public static void mostraCliente(Cinema cinema){
        String nomeCliente;
        String relatorio;
        
        nomeCliente = JOptionPane.showInputDialog(null, "Nome do Cliente ");
        
        Cliente cliente = cinema.getCliente(nomeCliente);
        if(cliente != null) {
            relatorio = ("\nNome: "+ cliente.getNome() +"\nIdade: "+ cliente.getIdade() +"\nCPF: "+ cliente.getCpf());
            JOptionPane.showMessageDialog(null, relatorio, "Relatorio", JOptionPane.PLAIN_MESSAGE);
        }
        else 
            JOptionPane.showMessageDialog(null, "Cliente Inexistente");
        
    }
}
