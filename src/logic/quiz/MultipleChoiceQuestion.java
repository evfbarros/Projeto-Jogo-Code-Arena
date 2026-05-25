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

    public void cortarAlternativasErradas(int quantidade) {

    // Lista que vai guardar os índices das alternativas erradas
    ArrayList<Integer> indicesErrados = new ArrayList<>();

    // Percorre todas as alternativas da questão
    for (int i = 0; i < alternativas.size(); i++) {

        // Se o índice atual for diferente do gabarito,
        // significa que essa alternativa está errada
        if (i != gabarito) {
            indicesErrados.add(i);
        }
    }

    // Embaralha os índices das alternativas erradas
    // para que as alternativas cortadas sejam escolhidas aleatoriamente
    java.util.Collections.shuffle(indicesErrados);

    // Contador de quantas alternativas já foram removidas
    int removidas = 0;

    // Percorre os índices errados já embaralhados
    for (int indice : indicesErrados) {

        // Se já removeu a quantidade desejada, para o loop
        if (removidas >= quantidade) {
            break;
        }

        // "Corta" a alternativa errada substituindo o texto por vazio
        alternativas.set(indice, "");

        // Atualiza o contador de alternativas removidas
        removidas++;
    }
}

    public int getGabarito() {
        return gabarito;
    }

    public ArrayList<String> getAlternativas() {
        return new ArrayList<>(alternativas);
    }

}
