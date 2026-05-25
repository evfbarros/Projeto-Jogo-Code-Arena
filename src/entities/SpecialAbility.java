package entities;

import logic.quiz.Question;

public interface SpecialAbility {
    boolean usar(Character personagem, Question questao, String resposta);
}
