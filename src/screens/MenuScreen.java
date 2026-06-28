package screens;

import java.util.*;
import logic.game.CampaignManager;

public class MenuScreen {
    private Scanner leitor = new Scanner(System.in);

    public void menu(CampaignManager campaignManager) {
        int escolha = 0;

        while (escolha != 4){
            limparTerminal();
            cabecalho("EAST BLUE CHRONICLES");

            System.out.println("[1] Jogar");
            System.out.println("[2] Como jogar");
            System.out.println("[3] Sobre");
            System.out.println("[4] Sair");

            System.out.println("════════════════════════════════════════");

            System.out.print("  -> ");

            escolha = 0;
            while (escolha < 1 || escolha > 4) {
                try {
                    escolha = leitor.nextInt();
                    leitor.nextLine();
                    if (escolha < 1 || escolha > 4) {
                        escolha = -1;
                        System.out.print("Escolha uma opcao valida (1 a 4): ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Escolha uma opçao valida (1 a 4): ");
                    leitor.nextLine();
                }
            }

            switch (escolha) {
                case 1:
                    limparTerminal();
                    campaignManager.iniciarCampanha();
                    break;
                case 2:
                    limparTerminal();
                    mostrarComoJogar();
                    break;
                case 3:
                    limparTerminal();
                    mostrarSobre();
                    break;
                case 4:
                    limparTerminal();
                    System.out.println("Saindo do jogo...\n" + "Obrigado por jogar!");
                    break;
            }
        }
    }

    public void mostrarComoJogar() {
        System.out.println("════════════════════════════════════════");
        System.out.println("           COMO JOGAR");
        System.out.println("════════════════════════════════════════");
        System.out.println();
        System.out.println("  East Blue Chronicles é um RPG de quiz");
        System.out.println("  por turnos inspirado em One Piece.");
        System.out.println();
        System.out.println("  Cada rodada, uma pergunta aparece.");
        System.out.println("  Resposta certa: você ataca o inimigo.");
        System.out.println("  Resposta errada: o inimigo te ataca.");
        System.out.println();
        System.out.println("  COMBATE");
        System.out.println("  -------");
        System.out.println("  Escolha entre responder normalmente");
        System.out.println("  ou usar sua habilidade especial.");
        System.out.println();
        System.out.println("  Se errar, escolha: Defender, Desviar");
        System.out.println("  ou Aceitar o ataque.");
        System.out.println();
        System.out.println("  PROGRESSÃO");
        System.out.println("  ----------");
        System.out.println("  Derrote inimigos para ganhar XP.");
        System.out.println("  Suba de nível e conquiste as 5 ilhas");
        System.out.println("  da East Blue!");
        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.print("\nPressione enter para voltar: ");
        leitor.nextLine();
    }

    private void mostrarSobre() {
        System.out.println("════════════════════════════════════════");
        System.out.println("             SOBRE O JOGO");
        System.out.println("════════════════════════════════════════");
        System.out.println();
        System.out.println("  East Blue Chronicles");
        System.out.println("  Versão 1.0");
        System.out.println();
        System.out.println("  Projeto desenvolvido para a disciplina");
        System.out.println("  de Linguagem de Programação Orientada");
        System.out.println("  a Objetos (LPOO).");
        System.out.println();
        System.out.println("  Universidade de Pernambuco - Poli UPE");
        System.out.println("  Professor: Leandro Honorato");
        System.out.println();
        System.out.println("  DESENVOLVEDORES");
        System.out.println("  ---------------");
        System.out.println("  Eduardo Vinícius");
        System.out.println("  Guilherme Alves");
        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.print("\nPressione enter para voltar: ");
        leitor.nextLine();
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

    public void limparTerminal() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}