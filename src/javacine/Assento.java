package javacine;

public class Assento {
    private int[] assentos = new int[200];
    private char situacao;
    private int id;
    
    public Assento(){}

    public Assento(char situacao, int id) {
        this.situacao = situacao;
        this.id = id;
    }

    public int[] getAssentos() {
        return assentos;
    }

    public void setAssentos(int[] assentos) {
        this.assentos = assentos;
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
