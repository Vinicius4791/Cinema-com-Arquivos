package javacine;

import java.io.Serializable;
import java.util.Date;

public class Sessao implements Serializable{
    private Date dataInicio;
    private Date dataFim;
    private Date horarioSessao;
    private boolean iniciada;
    private boolean encerrada;
    private int id;
    private Filme filme;
    
    public Sessao(){}

    public Sessao(Date dataInicio, Date dataFim, Date horarioSessao, boolean iniciada, boolean encerrada, int id, Filme filme) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horarioSessao = horarioSessao;
        this.iniciada = iniciada;
        this.encerrada = encerrada;
        this.id = id;
        this.filme = filme;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    public Date getHorarioSessao() {
        return horarioSessao;
    }

    public void setHorarioSessao(Date horarioSessao) {
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
