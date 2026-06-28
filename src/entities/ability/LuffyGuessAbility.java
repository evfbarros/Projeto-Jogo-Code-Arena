package entities.ability;

import java.util.Random;

import entities.Character;
import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;
import logic.quiz.TrueFalseQuestion;

public class LuffyGuessAbility implements SpecialAbility {

    // Objeto usado para sortear números aleatórios
    private Random random = new Random();

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        // Variável que vai guardar a chance de acerto do chute
        int chanceAcerto;

        // Se a questão for de múltipla escolha, Luffy terá 40% de chance de acertar
        if (questao instanceof MultipleChoiceQuestion) {
            chanceAcerto = 70;
        }

        // Se a questão for de verdadeiro ou falso, Luffy terá 70% de chance de acertar
        else if (questao instanceof TrueFalseQuestion) {
            chanceAcerto = 70;
        }

        // Tô pensando em implementar questões abertas, aí nelas não poderia usar essa habilidade.
        else {
            chanceAcerto = 0;
        }

        // Sorteia um número entre 1 e 100
        int numeroSorteado = random.nextInt(100) + 1;

        // Se o número sorteado estiver dentro da chance de acerto, retorna true
        // Exemplo: chance 40 → números de 1 a 40 acertam
        return numeroSorteado <= chanceAcerto;
    }
}