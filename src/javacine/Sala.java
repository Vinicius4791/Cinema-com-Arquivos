package javacine;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable{
    private int numeroSala;
    private ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
    
    public Sala(){}

    public Sala(int numeroSala, ArrayList<Sessao> sessoes) {
        this.numeroSala = numeroSala;
        this.sessoes = sessoes;
    }
    
    public void mostrarSala(int hora) {
        
        for(int i=0; i<10; i++) {
            System.out.print((i+1) +"  ");
            if(i==4)
                System.out.print("  ");
        }
        System.out.println("\n");
        
        for(Sessao sessao : sessoes) {
            if(sessao.getHorario() == hora) {
                char situacaoAssento[][] = sessao.getSituacaoAssento();
                
                for(int i=0; i < situacaoAssento.length; i++) {
                    for(int j=0; j < situacaoAssento[i].length; j++) {
                        System.out.print(situacaoAssento[i][j] +"  ");
                        if(j==4)
                            System.out.print("  ");
                
                    }
                System.out.println(" "+ (i+1)+"\n");
                }
            }
        }
    }
    
    public void escolherCadeira(int linha, int coluna, int hora) throws CadeiraOcupadaException {
        
        for(Sessao sessao : sessoes) {
            if(sessao.getHorario() == hora) {
                char situacaoAssento[][] = sessao.getSituacaoAssento();
                
                for(int i=0; i < situacaoAssento.length; i++) {
                    for(int j=0; j < situacaoAssento[i].length; j++) {
                        if(linha-1 == i && coluna-1 == j) {
                            if(situacaoAssento[i][j] == 'X')
                                throw new CadeiraOcupadaException();
                            else
                                situacaoAssento[i][j] = 'X';
                        }
                    }
                }
            }   
        }
        
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(ArrayList<Sessao> sessoes) {
        this.sessoes = sessoes;
    }
    
    public void setSessao(Sessao sessao){
	this.sessoes.add(sessao);
    }

    public Sessao getSala(int horario){
	for(Sessao sessao : sessoes){
            if(sessao.getHorario() == horario){
		return sessao;
            }
	}
	return null;
    }    
}
