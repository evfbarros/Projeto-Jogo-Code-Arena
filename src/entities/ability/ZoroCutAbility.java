package entities.ability;

import entities.Character;
import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;

public class ZoroCutAbility implements SpecialAbility {

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {
        if (questao instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion multiplaEscolha = (MultipleChoiceQuestion) questao;
            multiplaEscolha.cortarAlternativasErradas(3);
            return true;
        }

        return false;
    }
    @Override
    public String getNome() {
        return "Corte do Espadachim";
    }

    @Override
    public String getDescricao() {
        return "Zoro corta alternativas erradas em perguntas de multipla escolha, deixando a resposta correta mais facil de encontrar. Nao funciona em perguntas de verdadeiro ou falso ou completar lacuna.";
    }
}