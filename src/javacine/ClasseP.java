package javacine;

import javax.swing.JOptionPane;

public class ClasseP {
    public static void main(String[] args) {
        int menu;
        Cinema cinema = new Cinema();
        
        
    
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
                JOptionPane.showMessageDialog(null, "Opção Inválida", "ERRO", JOptionPane.PLAIN_MESSAGE);
                continue;
                }
        } 
        
    }
}
