package javacine;

import java.io.Serializable;
import java.util.Date;

public class Sessao implements Serializable{
    private Date dataSessao;
    private String horarioSessao;
    private boolean iniciada;
    private boolean encerrada;
    private int id;
    private Filme filme;
    
    public Sessao(){}

    public Sessao(Date dataSessao, String horarioSessao, boolean iniciada, boolean encerrada, int id, Filme filme) {
        this.dataSessao = dataSessao;
        this.horarioSessao = horarioSessao;
        this.iniciada = iniciada;
        this.encerrada = encerrada;
        this.id = id;
        this.filme = filme;
    }

    public Date getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(Date dataSessao) {
        this.dataSessao = dataSessao;
    }

    public String getHorarioSessao() {
        return horarioSessao;
    }

    public void setHorarioSessao(String horarioSessao) {
        this.horarioSessao = horarioSessao;
    }

    public boolean isIniciada() {
        return iniciada;
    }

    public void setIniciada(boolean iniciada) {
        this.iniciada = iniciada;
    }

    public boolean isEncerrada() {
        return encerrada;
    }

    public void setEncerrada(boolean encerrada) {
        this.encerrada = encerrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    
}
