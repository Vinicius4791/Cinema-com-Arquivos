package javacine;

public class Filme {
    private String titulo;
    private String duracao;
    private String genero;
    private String descricao;
    private int id;
    
    public Filme(){}

    public Filme(String titulo, String duracao, String genero, String descricao, int id) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.descricao = descricao;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
            
}
