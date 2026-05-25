package entities;

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
}
