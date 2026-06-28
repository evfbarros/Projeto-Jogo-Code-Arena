package screens;

import entities.CrewMember;
import java.util.*;

public class GameScreen {
    private Scanner leitor = new Scanner(System.in);

    public void exibirIlhaAtual(String nomeIlha) {
        cabecalho("ILHA ATUAL: " + nomeIlha.toUpperCase());
    }

    public void namiSaiu() {
        System.out.println("Nami saiu temporariamente da tripulacao...");
    }

    public void personagemEntrou(CrewMember personagem) {
        cabecalho(personagem.getNome() + " entrou para a tripulação!");
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

    public void esperarEnter() {
        System.out.print("\nPressione enter para continuar: ");
        leitor.nextLine();
    }
}