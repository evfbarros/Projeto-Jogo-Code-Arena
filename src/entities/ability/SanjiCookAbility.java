package entities.ability;

import entities.Character;
import logic.quiz.Question;

public class SanjiCookAbility implements SpecialAbility {

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        int cura = personagem.getVidaMaxima() / 2;

        personagem.recuperarVida(cura);

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
