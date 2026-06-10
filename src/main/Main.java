package main;

import entities.CharacterCreator;
import entities.Enemy;
import entities.Player;
import logic.game.GameManager;
import logic.quiz.QuestionBank;
import logic.quiz.QuestionManager;
import screens.BattleScreen;
import screens.QuestionScreen;

public class Main {

    public static void main(String[] args) {
        Player personagemjogador = new Player(CharacterCreator.personagemLuffy());
        Enemy inimigo = CharacterCreator.personagemCapitaoMorgan();

        BattleScreen battleScreen = new BattleScreen();
        QuestionScreen questionScreen = new QuestionScreen();

        String linkCsv = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSN2Jx7OKST0PhvuZAgNK7F_5CdqSAfOFTUT6VdRCyHvGid7KVX9C8vqpP11WpBQtCucKzqLPqdbSjH/pub?output=csv";
        QuestionBank banco = new QuestionBank(linkCsv);
        QuestionManager gerenciadorPergunta = new QuestionManager(banco.getListaQuestoes());

        GameManager gerenciadorJogo = new GameManager(personagemjogador, inimigo, gerenciadorPergunta, battleScreen, questionScreen);
        gerenciadorJogo.iniciarJogo();
    }
}