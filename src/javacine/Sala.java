package javacine;

import java.io.Serializable;

public class Sala implements Serializable{
    private int numeroSala;
    private Assento assentos;
    private int numeroAssentos;
    private Sessao sessao;
    
    public Sala(){}

    public Sala(int numeroSala, Assento assentos, Sessao sessao) {
        this.numeroSala = numeroSala;
        this.assentos = assentos;
        this.sessao = sessao;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Assento getAssentos() {
        return assentos;
    }

    public void setAssentos(Assento assentos) {
        this.assentos = assentos;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }
    
    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    
}
