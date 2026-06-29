package entities.ability;

import java.util.Random;

import entities.Character;
import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;
import logic.quiz.TrueFalseQuestion;

public class LuffyGuessAbility implements SpecialAbility {

    private Random random = new Random();

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        int chanceAcerto;
        if (questao instanceof MultipleChoiceQuestion) {
            chanceAcerto = 70;
        }
        else if (questao instanceof TrueFalseQuestion) {
            chanceAcerto = 70;
        }
        else {
            chanceAcerto = 0;
        }
        int numeroSorteado = random.nextInt(100) + 1;
        return numeroSorteado <= chanceAcerto;
    }
    @Override
    public String getNome() {
        return "Chute Instintivo";
    }

    @Override
    public String getDescricao() {
        return "Luffy tenta acertar a resposta no instinto. Funciona em perguntas de multipla escolha e verdadeiro ou falso. Nao funciona em perguntas de completar lacuna.";
    }
}