package screens;

import java.util.*;
import logic.game.CampaignManager;

public class MenuScreen {
    private Scanner leitor = new Scanner(System.in);

    public void menu(CampaignManager campaignManager) {
        int escolha = 0;

        while (escolha != 4) {
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
                    mostrarIntroducao();
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
    public void mostrarIntroducao() {
        cabecalho("PROLOGO");

        System.out.println();
        System.out.println("Em algum lugar do East Blue, existe uma pequena vila");
        System.out.println("chamada Foosha. Foi la que nasceu Monkey D. Luffy,");
        System.out.println("um garoto de 17 anos com um sonho grande demais para");
        System.out.println("caber em uma ilha: tornar-se o Rei dos Piratas.");
        System.out.println();

        System.out.println("Movido por esse desejo, Luffy parte em sua primeira");
        System.out.println("grande jornada pelo mar. Mas o oceano nao e apenas");
        System.out.println("um caminho de liberdade. Ele tambem e cheio de perigos,");
        System.out.println("misterios, disputas e historias esquecidas.");
        System.out.println();

        System.out.println("Ao longo da viagem, Luffy encontrara aliados, enfrentara");
        System.out.println("piratas perigosos, desafiara capitaes da Marinha e");
        System.out.println("descobrira que cada ilha guarda seus proprios problemas.");
        System.out.println();

        System.out.println("Neste mundo, o Governo Mundial controla grande parte");
        System.out.println("dos mares e impoe suas regras sobre reinos, cidades");
        System.out.println("e povos. A Marinha, seu braco militar, patrulha os");
        System.out.println("oceanos em nome da justica, perseguindo piratas e");
        System.out.println("mantendo a ordem.");
        System.out.println();

        System.out.println("Mas nem sempre justica e liberdade navegam na mesma");
        System.out.println("direcao.");
        System.out.println();

        System.out.println("Para seguir em frente, nao bastara vencer batalhas.");
        System.out.println("Cada etapa da jornada exigira conhecimento, estrategia");
        System.out.println("e coragem.");
        System.out.println();

        System.out.println("Questoes de Historia e Geografia surgirao como desafios");
        System.out.println("pelo caminho: rotas maritimas, povos, territorios,");
        System.out.println("conflitos, mapas, culturas e acontecimentos que moldam");
        System.out.println("o mundo.");
        System.out.println();

        System.out.println("Agora, a aventura começa.");
        System.out.println();

        System.out.println("Prepare-se para navegar pelo East Blue, superar inimigos,");
        System.out.println("recrutar companheiros e provar que o conhecimento tambem");
        System.out.println("pode ser uma arma poderosa.");
        System.out.println();

        System.out.println("════════════════════════════════════════");
        System.out.print("\nPressione enter para iniciar a jornada: ");
        leitor.nextLine();
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