package entities.ability;

import entities.Character;
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
    @Override
    public String getNome() {
        return "Mentira Convincente";
    }

    @Override
    public String getDescricao() {
        return "Usopp transforma uma mentira em vantagem: se a resposta estiver errada, ela passa a contar como certa. Mas cuidado: se a resposta estiver certa, ela passa a contar como errada.";
    }
}
