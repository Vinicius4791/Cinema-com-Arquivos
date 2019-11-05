package javacine;

public class Sala {
    private int numeroSala;
    private Assento assentos;
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

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    
}
