package main;

import entidades.Vilao;
import entidades.Tripulante;
import logica.jogo.GerenciadorJogo;
import logica.quiz.BancoQuestoes;
import logica.quiz.GerenciadorPergunta;

public class Main {

    public static void main(String[] args) {
        Tripulante jogador = new Tripulante("Luffy", 100, 50, 20, 50, 50, null);
        Vilao inimigo = new Vilao("Morgan", 100, 50, 20, 50, 50, null );
        //criacao de personagens bem basica so para testar 
        
        String linkCsv = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSN2Jx7OKST0PhvuZAgNK7F_5CdqSAfOFTUT6VdRCyHvGid7KVX9C8vqpP11WpBQtCucKzqLPqdbSjH/pub?output=csv";
        BancoQuestoes banco = new BancoQuestoes(linkCsv);
        GerenciadorPergunta gerenciadorPergunta = new GerenciadorPergunta(banco.getListaQuestoes());

        GerenciadorJogo gerenciadorJogo = new GerenciadorJogo(jogador, inimigo, gerenciadorPergunta);
        gerenciadorJogo.iniciarJogo();
    }
}