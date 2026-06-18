package entities.ability;

import entities.Character;
import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;

public class ZoroCutAbility implements SpecialAbility {

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        // Verifica se a questão atual é do tipo múltipla escolha.
        // A habilidade do Zoro só funciona nesse tipo de questão.
        if (questao instanceof MultipleChoiceQuestion) {

            // Converte a questão genérica Question para MultipleChoiceQuestion.
            // Isso permite acessar métodos específicos da questão de múltipla escolha.
            MultipleChoiceQuestion multiplaEscolha = (MultipleChoiceQuestion) questao;

            // Remove 3 alternativas erradas da questão.
            // A alternativa correta nunca é removida.
            multiplaEscolha.cortarAlternativasErradas(3);
            // Retorna true para indicar que a habilidade foi usada com sucesso.
            return true;
        }

        // Se a questão não for de múltipla escolha, a habilidade não é aplicada.
        return false;
    }
}