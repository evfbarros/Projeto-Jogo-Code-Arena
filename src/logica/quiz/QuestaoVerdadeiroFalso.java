package logica.quiz;

public class QuestaoVerdadeiroFalso extends Questao {
    private char gabarito;

    public QuestaoVerdadeiroFalso(String enunciado, int dificuldade, String categoria, char gabarito) {
        super(enunciado, dificuldade, categoria);
        this.gabarito = gabarito;
    }

    public char normalizarResposta(String resposta) {
        if (resposta == null) {
            return '\0';
        }

        String respostaLimpa = resposta.trim();

        if (respostaLimpa.length() != 1) {
            return '\0';
        }

        String respostaUpper = respostaLimpa.toUpperCase();
        char respostaChar = respostaUpper.charAt(0);

        if (respostaChar == 'V' || respostaChar == 'F') {
            return respostaChar;
        }

        return '\0';
    }

    @Override
    public boolean validarResposta(String resposta) {
        return normalizarResposta(resposta) != '\0';
    }

    @Override
    public boolean verificarResposta(String resposta) {
        char respostaChar = normalizarResposta(resposta);

        if (respostaChar == '\0') {
            return false;
        }

        return respostaChar == gabarito;
    }

    public char getGabarito() {
        return gabarito;
    }
}
