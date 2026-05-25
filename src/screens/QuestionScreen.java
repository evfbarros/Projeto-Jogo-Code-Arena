package screens;
import java.util.*;

import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;
import logic.quiz.TrueFalseQuestion;

public class QuestionScreen {
    private Scanner leitor = new Scanner(System.in);

    public void mostrarQuestao(Question questao){
        // Minha versão do java é mais antiga, aí tive que trocar pra não dar problema
        if (questao instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion multiplaEscolha = (MultipleChoiceQuestion) questao;
            mostrarQuestaoMultiplaEscolha(multiplaEscolha);
        } else if (questao instanceof TrueFalseQuestion) {
            TrueFalseQuestion verdadeiroFalso = (TrueFalseQuestion) questao; 
            mostrarVerdadeiroFalso(verdadeiroFalso);
        }
    }

    private void mostrarQuestaoMultiplaEscolha(MultipleChoiceQuestion questao){
        System.out.println(questao.getEnunciado());

        for (String alternativa : questao.getAlternativas()){
            System.out.println(alternativa);
        }
        System.out.print("Escolha uma alternativa (A-E): ");
    }

    private void mostrarVerdadeiroFalso(TrueFalseQuestion questao){
        System.out.println(questao.getEnunciado());
        System.out.print("Escolha entre V ou F:");
    }
    
    public String leituraRespostaValida(Question questaoAtual){
        String resposta;
        do {
            resposta = leitor.nextLine();
            if (!questaoAtual.validarResposta(resposta)) {
                System.out.print("Resposta invalida. Tente novamente: ");
            }
        } while (!questaoAtual.validarResposta(resposta));
        return resposta;
    }
    
}
