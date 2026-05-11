package logic.quiz;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
    private int gabarito; // o gabarito aqui vai ser o indice do array de alternativas que correponde a
                          // alternativa certa
    private ArrayList<String> alternativas;

    public MultipleChoiceQuestion(String enunciado, Difficulty dificuldade, String categoria,
            ArrayList<String> alternativas, int gabarito) {
        super(enunciado, dificuldade, categoria);
        this.alternativas = new ArrayList<>(alternativas);
        this.gabarito = gabarito;
    }

    @Override
    public void mostrarQuestao() {
        // System.out.println("\n---------ENUNCIADO---------\n");
        System.out.println(getEnunciado());

        for (int i = 0; i < alternativas.size(); i++) {
            System.out.println(alternativas.get(i));
        }

        System.out.print("Escolha uma alternativa (A-E): ");
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

        if (respostaChar == 'A' || respostaChar == 'B' || respostaChar == 'C' || respostaChar == 'D'
                || respostaChar == 'E') {
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

        int indice = respostaChar - 'A';
        return indice == gabarito;
    }

    public int getGabarito() {
        return gabarito;
    }

    public ArrayList<String> getAlternativas() {
        return new ArrayList<>(alternativas);
    }

}
