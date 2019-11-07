package javacine;

import java.io.Serializable;

public class Assento implements Serializable{
    private char situacao;
    private int id;
    
    public Assento(){}

    public Assento(char situacao, int id) {
        this.situacao = situacao;
        this.id = id;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
