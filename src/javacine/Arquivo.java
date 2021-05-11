package javacine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class Arquivo{
    //Escrita no arquivo
    public void write(Cinema cinema){
        try{
            
            FileOutputStream arquivo = new FileOutputStream("C:\\Users\\vinic\\Downloads\\Documents\\cinejava.txt");
            ObjectOutputStream obj = new ObjectOutputStream(arquivo);
            obj.writeObject(cinema);
            obj.flush();
            obj.close();
            arquivo.flush();
            arquivo.close();
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso.");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a gravação do arquivo.");
        }
    }
    //Leitura do arquivo
    public Cinema read(){
        try{
            FileInputStream arquivo = new FileInputStream("C:\\Users\\vinic\\Downloads\\Documents\\cinejava.txt");
            ObjectInputStream obj = new ObjectInputStream(arquivo);
            Cinema cinema = (Cinema)obj.readObject();
            obj.close();
            arquivo.close();
            return cinema;
            
        }
        catch(IOException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            return null;
        }
    }
}
