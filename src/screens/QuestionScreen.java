package screens;
import java.util.*;

import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;
import logic.quiz.TrueFalseQuestion;
import logic.quiz.OpenQuestion;
import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.OpenQuestion;
import logic.quiz.TrueFalseQuestion;

public class QuestionScreen {
    private Scanner leitor = new Scanner(System.in);
    private String instrucaoResposta = "Digite sua resposta";
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
        System.out.println();
        System.out.println("========================================");
        System.out.println("               PERGUNTA");
        System.out.println("Tipo: Pergunta de multipla escolha");
        System.out.println("========================================");

        System.out.println(questao.getEnunciado());

        System.out.println("----------------------------------------");

        for (String alternativa : questao.getAlternativas()){
            System.out.println(alternativa);
        }

        System.out.println("----------------------------------------");
        System.out.println("Leia a pergunta e escolha sua acao abaixo.");
        instrucaoResposta = "Digite uma opcao A-E";
    }

   private void mostrarVerdadeiroFalso(TrueFalseQuestion questao){
        System.out.println();
        System.out.println("========================================");
        System.out.println("               PERGUNTA");
        System.out.println("Tipo: Pergunta de verdadeiro ou falso");
        System.out.println("========================================");

        System.out.println(questao.getEnunciado());

        System.out.println("----------------------------------------");
        System.out.println("Leia a pergunta e escolha sua acao abaixo.");
        instrucaoResposta = "Digite V ou F";
    }

    private void mostrarQuestaoAberta(OpenQuestion questao){
        System.out.println();
        System.out.println("========================================");
        System.out.println("               PERGUNTA");
        System.out.println("Tipo: Pergunta de completar lacuna");
        System.out.println("========================================");

        System.out.println(questao.getEnunciado());

        System.out.println("----------------------------------------");
        System.out.println("Leia a pergunta e escolha sua acao abaixo.");
        instrucaoResposta = "Digite uma palavra";
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
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.print(instrucaoResposta + ": ");
    }
    public String obterRespostaCorreta(Question questao) {
        if (questao instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion multiplaEscolha = (MultipleChoiceQuestion) questao;

            int indiceCorreto = multiplaEscolha.getGabarito();
            char letraCorreta = (char) ('A' + indiceCorreto);
            String textoCorreto = multiplaEscolha.getAlternativas().get(indiceCorreto);

            return letraCorreta + " - " + textoCorreto;
        }

        if (questao instanceof TrueFalseQuestion) {
            TrueFalseQuestion verdadeiroFalso = (TrueFalseQuestion) questao;
            return String.valueOf(verdadeiroFalso.getGabarito());
        }

        if (questao instanceof OpenQuestion) {
            OpenQuestion aberta = (OpenQuestion) questao;
            return aberta.getRespostaCorreta();
        }

        return "Resposta não disponível";
    }
}
