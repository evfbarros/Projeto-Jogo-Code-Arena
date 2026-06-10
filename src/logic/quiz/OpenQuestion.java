package logic.quiz;

import java.text.Normalizer;

public class OpenQuestion extends Question {

    private String respostaCorreta;

    public OpenQuestion(String enunciado, Difficulty dificuldade, String categoria, String respostaCorreta) {
        super(enunciado, dificuldade, categoria);
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    public boolean validarResposta(String respostaUsuario) {
        return respostaUsuario != null && !respostaUsuario.trim().isEmpty();
    }

    @Override
    public boolean verificarResposta(String respostaUsuario) {
        if (respostaUsuario == null || respostaCorreta == null) {
            return false;
        }

        String respostaUsuarioNormalizada = normalizarTexto(respostaUsuario);
        String respostaCorretaNormalizada = normalizarTexto(respostaCorreta);

        return respostaUsuarioNormalizada.equals(respostaCorretaNormalizada);
}

    private String normalizarTexto(String texto) {
         String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);

        return textoNormalizado
            .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
            .trim()
            .toLowerCase()
            .replaceAll("\\s+", " ");
}

    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}
