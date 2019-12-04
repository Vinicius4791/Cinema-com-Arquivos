package javacine;

import java.io.Serializable;

public class Filme implements Serializable{
    private String titulo;
    private int duracao;
    private String genero;
    private String descricao;
    
    public Filme(){}

    public Filme(String titulo, int duracao, String genero, String descricao) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }      
}
