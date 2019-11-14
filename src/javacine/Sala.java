package javacine;

import java.io.Serializable;

public class Sala implements Serializable{
    private int numeroSala = 0;
    private Sessao sessao;
    private char[][] situacaoAssento = new char[2][50];
    
    public Sala(){}

    public Sala(Assento assentos, Sessao sessao) {
        numeroSala++;
        this.sessao = sessao;
    }
    
    public void criarSala() {
        for(int i=0; i < situacaoAssento.length; i++) {
            for(int j=0; j < situacaoAssento[i].length; j++) {
                situacaoAssento[i][j] = 'O';
            }
        }
    }
    
    public void mostrarSala() {
        for(int i=0; i < 2; i++) {
            for(int j=0; j < 50; i++) {
                System.out.println(situacaoAssento[i][j]);
            }
        }
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
    
    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    
}
