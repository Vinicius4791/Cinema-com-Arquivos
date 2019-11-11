package javacine;

import java.io.Serializable;

public class Sessao implements Serializable{
    private int diaSessao;
    private int mesSessao;
    private String horarioSessao;
    private boolean iniciada;
    private boolean encerrada;
    private int id;
    private Filme filme;
    
    public Sessao(){}

    public Sessao(int diaSessao, String horarioSessao, boolean iniciada, boolean encerrada, int id, Filme filme) {
        this.diaSessao = diaSessao;
        this.horarioSessao = horarioSessao;
        this.iniciada = iniciada;
        this.encerrada = encerrada;
        this.id = id;
        this.filme = filme;
    }

    public int getDiaSessao() {
        return diaSessao;
    }

    public void setDataSessao(int diaSessao) {
        this.diaSessao = diaSessao;
    }

    public int getMesSessao() {
        return mesSessao;
    }

    public void setMesSessao(int mesSessao) {
        this.mesSessao = mesSessao;
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
