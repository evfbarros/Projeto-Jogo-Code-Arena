package logica.quiz;

public abstract class Questao{
    protected String enunciado;
    protected Dificuldade dificuldade;
    protected String categoria;

    public Questao(String enunciado, Dificuldade dificuldade, String categoria){
        this.enunciado = enunciado;
        this.dificuldade = dificuldade;
        this.categoria = categoria;
    }

    public abstract boolean validarResposta(String resposta);

    public abstract boolean verificarResposta(String resposta);

    public String getEnunciado(){
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}