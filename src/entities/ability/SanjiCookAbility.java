package entities.ability;

import entities.Character;
import logic.quiz.Question;

public class SanjiCookAbility implements SpecialAbility {

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        // Calcula metade da vida máxima do personagem
        int cura = personagem.getVidaMaxima() / 2;

        // Recupera a vida do personagem.
        // O próprio método recuperarVida já impede passar da vida máxima.
        personagem.recuperarVida(cura);

        // Retorna true para indicar que a habilidade foi usada com sucesso
        return true;
    }
    @Override
    public String getNome() {
        return "Refeicao Revigorante";
    }

    @Override
    public String getDescricao() {
        return "Sanji prepara uma refeicao durante a batalha e recupera metade da vida maxima do personagem. Depois disso, o jogador ainda precisa responder a pergunta normalmente.";
    }
}
