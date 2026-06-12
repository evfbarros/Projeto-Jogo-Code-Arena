package entities.ability;

import entities.Character;
import logic.quiz.Question;

public interface SpecialAbility {
    boolean usar(Character personagem, Question questao, String resposta);
}
