package main;

import logica.quiz.BancoQuestoes;
import logica.quiz.GerenciadorPergunta;

public class Main {

    public static void main(String[] args) {

        String linkCsv =
        "https://docs.google.com/spreadsheets/d/e/2PACX-1vSN2Jx7OKST0PhvuZAgNK7F_5CdqSAfOFTUT6VdRCyHvGid7KVX9C8vqpP11WpBQtCucKzqLPqdbSjH/pub?output=csv";

        BancoQuestoes banco = new BancoQuestoes(linkCsv);

        GerenciadorPergunta gerenciador =
            new GerenciadorPergunta(banco.getListaQuestoes());

        System.out.println(
            "Questões carregadas: " +
            banco.getListaQuestoes().size()
        );

        // Sorteia uma questão aleatória
        int indice = gerenciador.questaoSorteada();

        // Mostra o enunciado da questão sorteada
        System.out.println(
            banco.getListaQuestoes().get(indice).getEnunciado()
        );
    }
}