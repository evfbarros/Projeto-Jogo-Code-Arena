package screens;

import entities.CrewMember;
import logic.game.Stats;

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

    public void campanhaEncerrada(String nomeInimigo, Stats stats) {
        System.out.println("════════════════════════════════════════");
        System.out.println("           FIM DE JOGO  ");
        System.out.println("   Você foi derrotado por " + nomeInimigo + ".");
        System.out.println("   A East Blue ainda não é sua...");
        System.out.println("════════════════════════════════════════");
        exibirStats(stats);
    }

    public void campanhaFinalizada(Stats stats) {
        System.out.println("════════════════════════════════════════");
        System.out.println("        VITÓRIA, PARABÉNS!  ");
        System.out.println("   Você conquistou a East Blue!");
        System.out.println("════════════════════════════════════════");
        exibirStats(stats);
    }

    private void exibirStats(Stats stats) {
        System.out.println();
        System.out.println("        ESTATÍSTICAS FINAIS");
        System.out.println("────────────────────────────────────────");
        System.out.println("  Rodadas jogadas:      " + stats.getRodadasJogadas());
        System.out.println("  Perguntas certas:     " + stats.getPerguntasAcertadas());
        System.out.println("  Perguntas erradas:    " + stats.getPerguntasErradas());
        System.out.println("  Dano total causado:   " + stats.getDanoTotalCausado());
        System.out.println("  Dano total recebido:  " + stats.getDanoTotalRecebido());
        System.out.println("────────────────────────────────────────");
        esperarEnter();
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