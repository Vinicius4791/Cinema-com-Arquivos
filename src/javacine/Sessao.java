package javacine;

import java.io.Serializable;
import java.util.Date;

public class Sessao implements Serializable{
    private Date dataInicio;
    private Date dataFim;
    private int horario;
    private Filme filme;
    private char[][] situacaoAssento = new char[10][10];
    
    public Sessao(){}

    public Sessao(Date dataInicio, Date dataFim, Filme filme) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.filme = filme;
    }
    public void disponibilizarCadeiras() {
        for(int i=0; i < situacaoAssento.length; i++) {
            for(int j=0; j < situacaoAssento[i].length; j++) {
                situacaoAssento[i][j] = 'O';
            }
        }
    }

    public char[][] getSituacaoAssento() {
        return situacaoAssento;
    }

    public void setSituacaoAssento(char[][] situacaoAssento) {
        this.situacaoAssento = situacaoAssento;
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

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    
}
