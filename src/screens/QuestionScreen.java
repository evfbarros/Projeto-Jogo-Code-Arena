package screens;

import java.util.*;

import logic.quiz.MultipleChoiceQuestion;
import logic.quiz.Question;
import logic.quiz.TrueFalseQuestion;
import logic.quiz.OpenQuestion;

public class QuestionScreen {
    private Scanner leitor = new Scanner(System.in);
    private String instrucaoResposta = "Digite sua resposta";

    public void mostrarQuestao(Question questao) {
        if (questao instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion multiplaEscolha = (MultipleChoiceQuestion) questao;
            mostrarQuestaoMultiplaEscolha(multiplaEscolha);
        } else if (questao instanceof TrueFalseQuestion) {
            TrueFalseQuestion verdadeiroFalso = (TrueFalseQuestion) questao;
            mostrarVerdadeiroFalso(verdadeiroFalso);
        } else if (questao instanceof OpenQuestion) {
            OpenQuestion questaoAberta = (OpenQuestion) questao;
            mostrarQuestaoAberta(questaoAberta);
        }
    }

    private void mostrarQuestaoMultiplaEscolha(MultipleChoiceQuestion questao) {
        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println("               PERGUNTA");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        imprimirComQuebra(questao.getEnunciado(), 40);

        System.out.println();
        System.out.println("────────────────────────────────────────");

        for (String alternativa : questao.getAlternativas()) {
            System.out.println(" " + alternativa);
        }

        System.out.println("────────────────────────────────────────");
        instrucaoResposta = "Digite uma opção (A-E)";
    }

    private void mostrarVerdadeiroFalso(TrueFalseQuestion questao) {
        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println("               PERGUNTA");
        System.out.println("════════════════════════════════════════");

        imprimirComQuebra(questao.getEnunciado(), 40);

        System.out.println("────────────────────────────────────────");
        System.out.println(" [V] Verdadeiro");
        System.out.println(" [F] Falso");
        System.out.println("────────────────────────────────────────");

        instrucaoResposta = "Digite V ou F";
    }

    private void mostrarQuestaoAberta(OpenQuestion questao) {
        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println("               PERGUNTA");
        System.out.println("════════════════════════════════════════");

        imprimirComQuebra(questao.getEnunciado(), 40);

        System.out.println("────────────────────────────────────────");
        instrucaoResposta = "Digite sua resposta";
    }

    public String leituraRespostaValida(Question questaoAtual) {
        String resposta;
        do {
            resposta = leitor.nextLine();
            if (!questaoAtual.validarResposta(resposta)) {
                System.out.print(" Resposta inválida. Tente novamente: ");
            }
        } while (!questaoAtual.validarResposta(resposta));
        return resposta;
    }

    public void pedirResposta() {
        System.out.println();
        System.out.println("────────────────────────────────────────");
        System.out.print(" " + instrucaoResposta + ": ");
    }

    public String obterRespostaCorreta(Question questao) {
        if (questao instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion multiplaEscolha = (MultipleChoiceQuestion) questao;

            int indiceCorreto = multiplaEscolha.getGabarito();
            String textoCorreto = multiplaEscolha.getAlternativas().get(indiceCorreto);

            return " " + textoCorreto;
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

    public static void imprimirComQuebra(String texto, int largura) {
        String[] palavras = texto.split(" ");
        StringBuilder linha = new StringBuilder("  ");

        for (String palavra : palavras) {
            if (linha.length() + palavra.length() + 1 > largura) {
                System.out.println(linha.toString());
                linha = new StringBuilder("  " + palavra + " ");
            } else {
                linha.append(palavra).append(" ");
            }
        }

        if (linha.length() > 2) {
            System.out.println(linha.toString());
        }
    }
}
