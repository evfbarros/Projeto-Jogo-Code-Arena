package screens;

import entities.CrewMember;

public class GameScreen {

    public void exibirIlhaAtual(String nomeIlha) {
        System.out.println("\n==============================");
        System.out.println("ILHA ATUAL: " + nomeIlha);
        System.out.println("==============================");
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
}