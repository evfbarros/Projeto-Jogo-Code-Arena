package logic.game;

import java.util.Scanner;

import entities.Character;
import logic.quiz.Question;
import logic.quiz.QuestionManager;

public class GameManager {
    private Character pJogador;
    private Character pInimigo;
    private QuestionManager gerenciadorPergunta;
    private Scanner leitor = new Scanner(System.in);

    public GameManager(Character pJogador, Character pInimigo, QuestionManager gerenciadorPergunta) {
        this.pJogador = pJogador;
        this.pInimigo = pInimigo;
        this.gerenciadorPergunta = gerenciadorPergunta;
    }

    public void iniciarJogo() {
        int rodada = 1;

        while (pJogador.estaVivo() == true && pInimigo.estaVivo() == true) {

            Question questaoAtual = gerenciadorPergunta.questaoSorteada();

            System.out.println("    -----RODADA " + rodada + "-----    ");

            questaoAtual.mostrarQuestao();

            String resposta;
            do {
                resposta = leitor.nextLine();
                if (!questaoAtual.validarResposta(resposta)) {
                    System.out.print("Resposta invalida. Tente novamente: ");
                }
            } while (!questaoAtual.validarResposta(resposta));

            if (questaoAtual.verificarResposta(resposta)) {
                System.out.println("\n----------RESULTADO RODADA " + rodada + "----------");
                System.out.println("          Resposta correta");
                System.out.println("          Voce causou " + pJogador.getAtaque() + " de dano");
                int dano = pJogador.atacar(pInimigo);
                pInimigo.receberDano(dano);
                // sistema de batalha bem basico, ainda falta implementar o sistema de verdade
            } else {
                System.out.println("\n----------RESULTADO RODADA " + rodada + "----------");
                System.out.println("          Resposta errada");
                System.out.println("          Voce recebeu " + pInimigo.getAtaque() + " de dano");
                int dano = pInimigo.atacar(pJogador);
                pJogador.receberDano(dano);
            }

            System.out.println("          Vida jogador: " + pJogador.getVida());
            System.out.println("          Vida inimigo: " + pInimigo.getVida());
            System.out.println("-------------------------------------");

            esperarEnter(); // Espera o cara dá enter para mudar de rodada

            limparTerminal(); // Limpa o terminal entre rodadas

            rodada++;
        }

        if (pJogador.estaVivo()) {
            System.out.println("-----FIM DE JOGO-----");
            System.out.println("\nPARABENS, VOCE VENCEU");
            System.out.println("\n---------------------");
            // System.out.println(personagemJogador.getNome() + " foi o ganhador da
            // batalha");
        } else if (pInimigo.estaVivo()) {
            System.out.println("-----------FIM DE JOGO----------");
            System.out.println("\nINFELIZMENTE VOCE FOI DERROTADO");
            System.out.println("\n--------------------------------");
            // System.out.println(personagemInimigo.getNome() + " foi o ganhador da
            // batalha");
        }
    }

    private void esperarEnter() {
        System.out.print("\nPressione enter para continuar: ");
        leitor.nextLine();
    }

    private void limparTerminal() {
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