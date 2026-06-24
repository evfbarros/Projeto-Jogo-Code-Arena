package main;

import entities.CharacterCreator;
import entities.Player;
import logic.game.CampaignManager;
import logic.quiz.QuestionBank;
import logic.quiz.QuestionManager;
import screens.GameScreen;

public class Main {

    public static void main(String[] args) {
        Player jogador = new Player(CharacterCreator.personagemLuffy());

        String linkCsv = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSN2Jx7OKST0PhvuZAgNK7F_5CdqSAfOFTUT6VdRCyHvGid7KVX9C8vqpP11WpBQtCucKzqLPqdbSjH/pub?output=csv";

        QuestionBank banco = new QuestionBank(linkCsv);
        QuestionManager gerenciadorPergunta = new QuestionManager(banco.getListaQuestoes());

        GameScreen gameScreen = new GameScreen();

        CampaignManager campanha = new CampaignManager(
                jogador,
                gerenciadorPergunta,
                gameScreen
        );

        campanha.iniciarCampanha();
    }
}