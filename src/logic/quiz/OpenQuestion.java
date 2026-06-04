package logic.quiz;

public class OpenQuestion extends Question {

    private String respostaCorreta;

    public OpenQuestion(String enunciado, Difficulty dificuldade, String categoria, String respostaCorreta) {
        super(enunciado, dificuldade, categoria);
        this.respostaCorreta = respostaCorreta;
    }

    /**
     * Método que valida a resposta do usuário.
     * Retorna true se a resposta do usuário estiver correta.
     */
    @Override
    public boolean validarResposta(String respostaUsuario) {
        return respostaUsuario.trim().equalsIgnoreCase(respostaCorreta);
    }

    /**
     * Método complementar para compatibilidade com a lógica de verificação de respostas.
     */
    @Override
    public boolean verificarResposta(String respostaUsuario) {
        return validarResposta(respostaUsuario);
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}
