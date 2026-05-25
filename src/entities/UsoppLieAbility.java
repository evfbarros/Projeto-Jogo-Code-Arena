package entities;

import logic.quiz.Question;

public class UsoppLieAbility implements SpecialAbility {

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        // Verifica se a resposta original estaria correta
        boolean respostaOriginalCorreta = questao.verificarResposta(resposta);

        // A habilidade do Usopp inverte o resultado:
        // se o jogador errou, passa a acertar
        // se o jogador acertou, passa a errar
        return !respostaOriginalCorreta;
    }
}
