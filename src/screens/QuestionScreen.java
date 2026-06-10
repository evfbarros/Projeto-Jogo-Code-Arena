package screens;
import java.util.*;

import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;
import logic.quiz.TrueFalseQuestion;
import logic.quiz.OpenQuestion;

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
        } else if(questao instanceof OpenQuestion) {
            OpenQuestion questaoAberta = (OpenQuestion) questao;
            mostrarQuestaoAberta(questaoAberta);
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

    private void mostrarQuestaoAberta(OpenQuestion questao) {
        System.out.println(questao.getEnunciado());
        System.out.print("Digite sua resposta: ");
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
    public void pedirResposta() {
        System.out.print("Resposta: ");
    }
    
}
