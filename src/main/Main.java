package main;

import entities.CrewMember;
import entities.Enemy;
import logic.game.GameManager;
import logic.quiz.QuestionBank;
import logic.quiz.QuestionManager;

public class Main {

    public static void main(String[] args) {
        CrewMember jogador = new CrewMember("Luffy", 100, 50, 20, 50, 50, null);
        Enemy inimigo = new Enemy("Morgan", 100, 50, 30, 50, 50, null);
        // criacao de personagens bem basica so para testar

        String linkCsv = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSN2Jx7OKST0PhvuZAgNK7F_5CdqSAfOFTUT6VdRCyHvGid7KVX9C8vqpP11WpBQtCucKzqLPqdbSjH/pub?output=csv";
        QuestionBank banco = new QuestionBank(linkCsv);
        QuestionManager gerenciadorPergunta = new QuestionManager(banco.getListaQuestoes());

        GameManager gerenciadorJogo = new GameManager(jogador, inimigo, gerenciadorPergunta);
        gerenciadorJogo.iniciarJogo();
    }
}