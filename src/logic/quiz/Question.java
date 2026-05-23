package logic.quiz;

public abstract class Question {
    protected String enunciado;
    protected Difficulty dificuldade;
    protected String categoria;

    public Question(String enunciado, Difficulty dificuldade, String categoria) {
        this.enunciado = enunciado;
        this.dificuldade = dificuldade;
        this.categoria = categoria;
    }

    public abstract boolean validarResposta(String resposta);

    public abstract boolean verificarResposta(String resposta);

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Difficulty getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Difficulty dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}