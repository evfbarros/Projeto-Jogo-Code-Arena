package logica.quiz;

public abstract class Questao{
    protected String enunciado;
    protected int dificuldade;
    protected String categoria;

    public Questao(String enunciado, int dificuldade, String categoria){
        this.enunciado = enunciado;
        this.dificuldade = dificuldade;
        this.categoria = categoria;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}