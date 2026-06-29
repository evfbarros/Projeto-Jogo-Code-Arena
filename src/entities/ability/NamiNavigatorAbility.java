package entities.ability;

import entities.Character;
import logic.quiz.Question;

public class NamiNavigatorAbility implements SpecialAbility {
    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        // Verifica se a categoria da questão é Geografia
        if (questao.getCategoria().equalsIgnoreCase("GEOGRAFIA")) {

            // Retorna true indicando que a habilidade acertou automaticamente
            return true;
        }

        // Se não for Geografia, a habilidade não funciona
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
