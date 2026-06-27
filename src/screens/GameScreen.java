package screens;

import entities.CrewMember;

public class GameScreen {

    public void exibirIlhaAtual(String nomeIlha) {
        cabecalho("ILHA ATUAL: " + nomeIlha.toUpperCase());
    }

    public void namiSaiu() {
        System.out.println("Nami saiu temporariamente da tripulacao...");
    }

    public void personagemEntrou(CrewMember personagem) {
        System.out.println(personagem.getNome() + " entrou para a tripulacao!");
    }

    public void campanhaEncerrada(String nomeInimigo) {
        System.out.println("Campanha encerrada. Voce perdeu para " + nomeInimigo + ".");
    }

    public void campanhaFinalizada() {
        System.out.println("\nPARABENS! VOCE FINALIZOU A CAMPANHA EAST BLUE!");
    }

    public void cabecalho(String texto) {
        int largura = 40;
        String linha = "═".repeat(largura);
        int espacos = (largura - texto.length()) / 2;
        String padding = " ".repeat(Math.max(0, espacos));
        System.out.println(linha);
        System.out.println(padding + texto);
        System.out.println(linha);
    }

}