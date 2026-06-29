package entities.ability;

import entities.Character;
import logic.quiz.Question;

public class NamiNavigatorAbility implements SpecialAbility {
    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        if (questao.getCategoria().equalsIgnoreCase("GEOGRAFIA")) {

            return true;
        }

        return false;
    }
    @Override
    public String getNome() {
        return "Navegadora dos Mares";
    }

    @Override
    public String getDescricao() {
        return "Nami usa seu conhecimento de navegacao para acertar automaticamente perguntas de Geografia. A habilidade nao funciona em perguntas de Historia.";
    }
}
